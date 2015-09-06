package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.net.{URI, URLDecoder, URLEncoder}
import models.User
import views._
import scala.util.Random

import com.swisscom.scsapi.commons.crypto.RsaCryptoHelper

case class PaymentsInfo(UUID: String, Flow: String)

/**
 * @author TAABOAM1
 */
object PaymentsFlowPartnerAgent extends Controller {
  
  /**
   * Form that specifies the UUID for the Partner/Agent flow
   */
  val paymentsinfoForm: Form[PaymentsInfo] = Form(
    // Define a mapping that will handle User values
    mapping(
      "UUID" -> nonEmptyText,
      "Flow" -> nonEmptyText)(PaymentsInfo.apply)(PaymentsInfo.unapply))
      
  
  /**
   * Index page that presents the form.
   */
  def index(backend : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".paymentsflowpartneragent.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".paymentsflowpartneragent.redirect_uri").get

    Ok(html.consent.PaymentsFlowPartnerAgent.index(backend, paymentsinfoForm, null, None))
  }
  
  /**
   * Creates the secret from a UUID
   */
  def createSecret(myUUID : String) : String = {
    myUUID + ":" + System.currentTimeMillis
  }
  
  /**
   * Receives the form with the UUID, encrypts the UUID, and calls the consent for an access token.
   */
  def consentRedirect(backend : String) = Action { implicit request =>
    paymentsinfoForm.bindFromRequest.fold(
      formWithErrors => {
      // binding failure, you retrieve the form containing errors:
        BadRequest(html.consent.PaymentsFlowPartnerAgent.index(backend, formWithErrors, null, None))
      },
      paymentsInfo => {
        val client_id = Play.current.configuration.getString(backend + ".paymentsflowpartneragent.client_id").get
        val redirect_uri= Play.current.configuration.getString(backend + ".paymentsflowpartneragent.redirect_uri_payments").get
        val secret = createSecret(paymentsInfo.UUID)
        val privateKeyBase64 = Play.current.configuration.getString(backend + ".paymentsflowpartneragent.privatekey").get
        val encryptedSecret = RsaCryptoHelper.encryptValueWithPrivateKey(privateKeyBase64, secret)
        val amount = "10" //request.getQueryString("payment_amount").getOrElse("10")
        
        var authorizationUrl = ""
        if (paymentsInfo.Flow == "true") {
          //Partner Flow
          authorizationUrl = "https://consent.int.swisscom.com/c/oauth2/auth?"
        } else {
          //Agent Flow
          authorizationUrl =  "https://sirius.test.swissptt.ch/c/oauth2/auth?"
        }
        authorizationUrl = authorizationUrl + "response_type=code" + "&client_id=" + URLEncoder.encode(client_id) + "&lang=de" + "&redirect_uri=" + URLEncoder.encode(redirect_uri) + "&uuid=" + URLEncoder.encode(encryptedSecret)
        Logger.debug("Authorizing against URL" + authorizationUrl)
        Redirect(authorizationUrl).withSession(session + ("payments.payment_amount" -> amount))          
      }
    )

  }
        
        
  def consentCallback(backend : String) = Action { implicit request =>
    Logger.debug("Request: " + request)
    val code = request.getQueryString("code").getOrElse("NULL")
    Logger.debug("Code received from consent: " + code)
    if ("NULL".equals(code)) {
      InternalServerError(html.consent.PaymentsFlowPartnerAgent.index(backend, paymentsinfoForm, null, 
          Some("Failed to get access code from consent > " + request.getQueryString("error").get + " [ " + request.getQueryString("error_description").get + " ]")))
    } else {
      val redirectUri = Play.current.configuration.getString(backend + ".paymentsflowpartneragent.redirect_uri_payments").get
      val authHeader = Play.current.configuration.getString(backend + ".paymentsflowpartneragent.auth_header").get
      val paymentsEndpoint = Play.current.configuration.getString(backend + ".payments_endpoint").get
  
      val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend)
      
      //Test purpose
      if (accessToken.isRight) {
        val response = ApigeeCallouts.chargePayment(accessToken.right.get, backend, session.get("payments.payment_amount").get)
        val json = response.toString
        Ok(html.consent.PaymentsFlowPartnerAgent.index(backend, paymentsinfoForm, json, None))
      } else {
        InternalServerError(html.consent.PaymentsFlowPartnerAgent.index(backend, paymentsinfoForm, null, Some("Error getting access token - " + accessToken.left.get)))
      }
    }
  }

}