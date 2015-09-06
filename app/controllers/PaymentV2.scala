package controllers


import java.net.URLEncoder

import com.swisscom.scsapi.commons.crypto.RsaCryptoHelper
import controllers.PaymentsFlowPartnerAgent._
import play.api._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import views._

/** Reflects payment/refund form for selfcare/partner/agent flows. */
case class PaymentData(endUserId: String, amount: BigDecimal, currency: String, description: String, locale: String,
                       onBehalfOf: String, purchaseCategoryCode: String, taxRate: BigDecimal, referenceCode: String,
                       authCode: String)

object PaymentV2 extends Controller {
  /* Payment/Refund flows related constants. */
  val FlowPaymentSelfcare = "payselfcare"
  val FlowRefundSelfcare = "refundselfcare"
  val FlowPaymentPartnerAgent = "paypartneragent"
  val FlowRefundPartnerAgent = "refundpartneragent"

  /**
   * Form that specifies the UUID for the Partner/Agent flow
   */
  val paymentsinfoForm: Form[PaymentsInfo] = Form(
    // Define a mapping that will handle User values
    mapping(
      "UUID" -> nonEmptyText,
      "Flow" -> nonEmptyText)(PaymentsInfo.apply)(PaymentsInfo.unapply))

  /** Form for payment/refund selfcare. */
  val paymentSelfcareForm: Form[PaymentData] = Form(mapping(
    "endUserId" -> text,
    "amount" -> bigDecimal,
    "currency" -> text,
    "description" -> text,
    "locale" -> text,
    "onBehalfOf" -> text,
    "purchaseCategoryCode" -> text,
    "taxRate" -> bigDecimal,
    "referenceCode" -> text,
    "authCode" -> text
  )(PaymentData.apply)(PaymentData.unapply))

  val encoding = "UTF-8"

  /**
   * Index page that presents the form.
   */
  def index(backend : String) = Action { implicit request =>
    Ok(html.consent.paymentv2.index(backend))
  }

  def transactions(backend : String) = Action { implicit request =>
    Ok(html.consent.paymentv2.transactions.index(backend))
  }
  
  def refund(backend : String) = Action { implicit request =>
    Ok(html.consent.paymentv2.amountrefund.index(backend))
  }

  def pay(backend : String) = Action { implicit request =>
    Ok(html.consent.paymentv2.amountpay.index(backend))
  }

  /**
   * Payment/refund selfcare: render initial screen.
   *
   * @param backend backend name: local/int/ext
   * @param flow flow name: transactions/payselfcare/refundselfcare
   */
  def payselfcare(backend : String, flow : String) = Action { implicit request =>
    println("payselfcare: " + flow)
    val clientId = Play.current.configuration.getString(backend + ".paymentsV2flowselfcare.client_id").get
    val redirectUri = Play.current.configuration.getString(backend + ".paymentsV2flowselfcare.redirect_uri").get + "&flow=" + flow

    Ok(html.consent.paymentv2.amountpay.selfcare(backend, redirectUri, clientId, None, None, None, flow))
  }

  /**
   * Payment/refund selfcare: render input form.
   * This is NOT a controller method;
   * this method is invoked from the dispatcher controller method transactionscallback.
   *
   * @param backend backend name: local/int/ext
   * @param flow flow name: transactions/payselfcare/refundselfcare
   */
  def payselfcareStep1(backend : String, flow : String)(implicit request: Request[AnyContent]) = {
    val code = request.getQueryString("code").getOrElse("NULL")
    println("payselfcareStep1: " + flow)

    val error = request.getQueryString("error").getOrElse(None);
    val errorDesc = request.getQueryString("error_description").getOrElse(None);
    if (None == error) {
      Ok(html.consent.paymentv2.amountpay.selfcareStep1(backend, code, paymentSelfcareForm, flow, None));
    } else {
      InternalServerError(html.consent.paymentv2.amountpay.selfcareStep1(backend, code, paymentSelfcareForm, flow, Some("Error getting access token/code from consent: " + error + " - " + errorDesc)));
    }
  }

  /**
   * Payment/refund selfcare: retrieve data from input form, send it to the API, show request to and response from API.
   *
   * @param backend backend name: local/int/ext
   * @param flow flow name: transactions/payselfcare/refundselfcare
   */
  def payselfcareStep2(backend : String, flow : String) = Action { implicit request =>
    println("payselfcareStep2: " + flow)
    val paymentData = paymentSelfcareForm.bindFromRequest().get
    println("" + paymentData)
    val code = paymentData.authCode

    // Get configuration values
    val clientId = Play.current.configuration.getString(backend + ".paymentsV2flowselfcare.client_id").get
    val redirectUri = Play.current.configuration.getString(backend + ".paymentsV2flowselfcare.redirect_uri").get + "&flow=" + flow
    val authHeader = Play.current.configuration.getString(backend + ".paymentsV2flowselfcare.auth_header").get
    printf("code=%s, clientId=%s, redirectUri=%s, authHeader=%s %n", code, clientId, redirectUri, authHeader)

    // Get the access token
    val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend)
    println("token: " + accessToken)

    //Test purpose
    if (accessToken.isRight) {
      // Invoke API
      val result = ApigeeCallouts.paymentTransactionPay(accessToken.right.get, paymentData, backend, if (flow == FlowRefundSelfcare) "refunded" else "charged" )
      val requestJson = result._1
      val responseJson = result._2
      Ok(html.consent.paymentv2.amountpay.selfcare(backend, redirectUri, clientId, Some(requestJson), Some(responseJson), None, flow))
    } else {
      Ok(html.consent.paymentv2.amountpay.selfcare(backend, redirectUri, clientId, None, None, Some("Error getting access token - " + accessToken.left.get), flow))
    }
  }

  def paypartneragent(backend : String, flow : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.redirect_uri").get

    Ok(html.consent.paymentv2.payrefund.partneragent(backend, redirect_uri, client_id, flow, None, None, None, paymentsinfoForm ))
  }
  
  def paypartneragentFormCapture(backend : String, flow : String)(implicit request: Request[AnyContent]) = {
    Logger.debug("Received request: " + request.toString())
    val code = request.getQueryString("code").getOrElse("NULL")
    val error = request.getQueryString("error").getOrElse(None)
    val errorDesc = request.getQueryString("error_description").getOrElse(None)
    if (None == error) {
      Ok(html.consent.paymentv2.payrefund.partneragentFormCapture(backend, code, paymentSelfcareForm, flow, None))
    } else {
      InternalServerError(html.consent.paymentv2.payrefund.partneragentFormCapture(backend, code, paymentSelfcareForm, flow, Some("Error getting access token/code from consent: " + error + " - " + errorDesc)))
    }
  }

  def paypartneragentRedirect(backend : String, flow : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.redirect_uri").get + "&flow=" + flow
  
    paymentsinfoForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(html.consent.paymentv2.payrefund.partneragent(backend, redirect_uri, client_id, flow, None, None, None, formWithErrors))
      },
      paymentsInfo => {
        val secret = createSecret(paymentsInfo.UUID)
        val privateKeyBase64 = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.privatekey").get
        val encryptedSecret = RsaCryptoHelper.encryptValueWithPrivateKey(privateKeyBase64, secret)
        if (paymentsInfo.Flow == "true") {
          //Partner Flow
          val consentPartnerFlowURL = Play.current.configuration.getString(backend + ".consent_endpoint").get
          val consentRedirectUrl = consentPartnerFlowURL+"?response_type=code"+"&client_id="+URLEncoder.encode(client_id, encoding)+"&lang=de"+"&redirect_uri="+URLEncoder.encode(redirect_uri, encoding)+"&uuid="+URLEncoder.encode(encryptedSecret, encoding)
          Logger.debug("consent redirect url: " + consentRedirectUrl)
          Redirect(consentRedirectUrl)
        } else {
          //Agent Flow (Internal Nevis)
          val consentAgentFlowURL =  Play.current.configuration.getString(backend + ".consent_agent_endpoint").get
          val consentRedirectUrl = consentAgentFlowURL+"?response_type=code"+"&client_id="+URLEncoder.encode(client_id, encoding)+"&lang=de"+"&redirect_uri="+URLEncoder.encode(redirect_uri, encoding)+"&uuid="+URLEncoder.encode(encryptedSecret, encoding)
          Logger.debug("consent redirect url: " + consentRedirectUrl)
          Redirect(consentRedirectUrl)
        }
      }
    )
  }

  def paypartneragentApigeeCall(backend : String, flow : String) = Action { implicit request =>
    val paymentData = paymentSelfcareForm.bindFromRequest().get
    val code = paymentData.authCode

    // Get configuration values
    val clientId = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.client_id").get
    val redirectUri = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.redirect_uri").get + "&flow=" + flow
    val authHeader = Play.current.configuration.getString(backend + ".paymentsV2" + flow + "flow.auth_header").get

    // Get the access token
    val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend)
    Logger.info("token: " + accessToken)

    //Test purpose
    if (accessToken.isRight) {
      // Invoke API
      val result = ApigeeCallouts.paymentTransactionPay(accessToken.right.get, paymentData, backend, if (flow == FlowPaymentPartnerAgent) "charged" else "refunded" )
      val requestJson = result._1
      val responseJson = result._2
      Ok(html.consent.paymentv2.payrefund.partneragent(backend, redirectUri, clientId, flow, Some(requestJson), Some(responseJson), None, paymentsinfoForm))
    } else {
      Ok(html.consent.paymentv2.payrefund.partneragent(backend, redirectUri, clientId, flow, None, None, Some("Error getting access token - " + accessToken.left.get), paymentsinfoForm))
    }
  }

  def transactionsselfcare(backend : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".transactions.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".transactions.redirect_uri").get + "&flow=transactions"

    Ok(html.consent.paymentv2.transactions.selfcare(backend, redirect_uri, client_id, null, None))
  }

  /**
   * This is NOT a controller method;
   * this method is invoked from the dispatcher controller method transactionscallback.
   *
   * @param backend backend name: local/int/ext
   */
  def transactionsselfcarecallback(backend : String)(implicit request: Request[AnyContent]) = {
    // Get the code from the callback
    val code = request.getQueryString("code").getOrElse("NULL")

    // Get configuration values
    val client_id = Play.current.configuration.getString(backend + ".transactions.client_id").get
    val redirectUri = Play.current.configuration.getString(backend + ".transactions.redirect_uri").get + "&flow=transactions"
    val authHeader = Play.current.configuration.getString(backend + ".transactions.auth_header").get

    // Get the access token
    val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend)

    //Test purpose
    if (accessToken.isRight) {
      val response = ApigeeCallouts.paymentTransactions(accessToken.right.get, backend)
      val json = response.toString
      Ok(html.consent.paymentv2.transactions.selfcare(backend, redirectUri, client_id, json, None))
    } else {
      Ok(html.consent.paymentv2.transactions.selfcare(backend, redirectUri, client_id, null, Some("Error getting access token - " + accessToken.left.get)))
    }
  }

  /**
   * Request dispatcher after redirection from Consent server.
   * This is a callback method - mapped to the Callback URL defined in apigee and invoked from Consent server.
   *
   * @param backend backend name: local/int/ext
   * @param flow flow name: transactions/payselfcare/refundselfcare
   */
  def transactionscallback(backend : String, flow: String) = Action { implicit request =>
    flow match {
      case "transactions" => transactionsselfcarecallback(backend)
      case FlowPaymentSelfcare => payselfcareStep1(backend, FlowPaymentSelfcare)
      case FlowRefundSelfcare => payselfcareStep1(backend, FlowRefundSelfcare)
      case FlowPaymentPartnerAgent => paypartneragentFormCapture(backend, FlowPaymentPartnerAgent)
      case FlowRefundPartnerAgent => paypartneragentFormCapture(backend, FlowRefundPartnerAgent)
      case _ => throw new IllegalArgumentException("Unsupported flow: " + flow)
    }
  }

  def transactionspartneragent(backend : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".transactions.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".transactions.redirect_uri").get + "&flow=transactions"

    Ok(html.consent.paymentv2.transactions.partneragent(backend, redirect_uri, client_id, null, None, paymentsinfoForm ))
  }

  def partneragentconsentRedirect(backend : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".transactions.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".transactions.redirect_uri").get + "&flow=transactions"

    paymentsinfoForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors:
        BadRequest(html.consent.paymentv2.transactions.partneragent(backend, redirect_uri, client_id, null, None, formWithErrors))
      },
      paymentsInfo => {
        val client_id = Play.current.configuration.getString(backend + ".transactions.client_id").get
        val redirect_uri= Play.current.configuration.getString(backend + ".transactions.redirect_uri").get + "&flow=transactions"
        val secret = createSecret(paymentsInfo.UUID)
        val privateKeyBase64 = Play.current.configuration.getString(backend + ".transactions.privatekey").get
        val encryptedSecret = RsaCryptoHelper.encryptValueWithPrivateKey(privateKeyBase64, secret)
        if (paymentsInfo.Flow == "true") {
          //Partner Flow
          val consentPartnerFlowURL = Play.current.configuration.getString(backend + ".consent_endpoint").get
          Redirect(consentPartnerFlowURL+"?response_type=code"+"&client_id="+URLEncoder.encode(client_id, encoding)+"&lang=de"+"&redirect_uri="+URLEncoder.encode(redirect_uri, encoding)+"&uuid="+URLEncoder.encode(encryptedSecret, encoding))
        } else {
          //Agent Flow (Internal Nevis)
          val consentAgentFlowURL =  Play.current.configuration.getString(backend + ".consent_agent_endpoint").get
          Redirect(consentAgentFlowURL+"?response_type=code"+"&client_id="+URLEncoder.encode(client_id, encoding)+"&lang=de"+"&redirect_uri="+URLEncoder.encode(redirect_uri, encoding)+"&uuid="+URLEncoder.encode(encryptedSecret, encoding))
        }
      }
    )
  }
}