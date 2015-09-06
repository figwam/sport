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


/**
 * @author TAACHFR1
 */
object PaymentsFlowSelfcare extends Controller {
  
  def index(backend : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".paymentsflowselfcare.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".paymentsflowselfcare.redirect_uri").get

    val amount = session.get("payments.selfcare.payment_amount").getOrElse("10")
    Ok(html.consent.PaymentsFlowSelfcare.index(backend, redirect_uri, client_id, null, amount, None))
  }

  def savePaymentAmount() = Action { implicit request => 
    val amount = request.getQueryString("payment-amount").getOrElse("10")
    Logger.info("Setting new payment amount for session to: " + amount)
    Ok("{ \"message\": \"success\" }").as("application/javascript").withSession(session + ("payments.selfcare.payment_amount" -> amount))
  }
  
  def consentCallback(backend : String) = Action { implicit request =>
    val code = request.getQueryString("code").getOrElse("NULL")
    val client_id = Play.current.configuration.getString(backend + ".paymentsflowselfcare.client_id").get    
    val redirectUri = Play.current.configuration.getString(backend + ".paymentsflowselfcare.redirect_uri").get
    val authHeader = Play.current.configuration.getString(backend + ".paymentsflowselfcare.auth_header").get
    val paymentsEndpoint = Play.current.configuration.getString(backend + ".payments_endpoint").get
    val amount = session.get("payments.selfcare.payment_amount").getOrElse("10")
    
    val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend);
    //Test purpose
    if (accessToken.isRight) {
    	val response = ApigeeCallouts.chargePayment(accessToken.right.get, backend, amount)
    	val json = response.toString
    	Ok(html.consent.PaymentsFlowSelfcare.index(backend, redirectUri, client_id, json, amount, None))
    } else {
    	Ok(html.consent.PaymentsFlowSelfcare.index(backend, redirectUri, client_id, null, amount, Some("Error getting access token - " + accessToken.left.get)))
    }

  }

}