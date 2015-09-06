package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.net.{URI, URLDecoder, URLEncoder}
import models.User

import views._

object ConsentPayment extends Controller {
  
  def login(backend : String) = Action { implicit request =>
    val consentEndpoint = Play.current.configuration.getString(backend + ".consent_endpoint").getOrElse("beats me")
    val clientId = Play.current.configuration.getString(backend + ".payment.client_id").getOrElse("beats me")
    val redirectUri = Play.current.configuration.getString(backend + ".payment.redirect_uri").getOrElse("beats me")
    
    Redirect(consentEndpoint + "?client_id="+URLEncoder.encode(clientId, "UTF-8")+"&redirect_uri="+URLEncoder.encode(redirectUri, "UTF-8")+"&response_type=code")
  }

  def index(backend : String) = Action { implicit request =>
    val redirectUri = Play.current.configuration.getString(backend + ".payment.redirect_uri").getOrElse("beats me")
    val authHeader = Play.current.configuration.getString(backend + ".payment.auth_header").getOrElse("beats me")
    val code = request.getQueryString("code").getOrElse("NULL")

    //auth code grant
    Logger.debug("auth code grant with code: " + code);

    val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend)

    Ok(html.consent.payment.index(accessToken, Right(""), "0,00", None, backend))
  }
  
  def reserve(accessToken: String, amount : String, transactionId : String, backend : String) = Action { implicit request =>

    if (transactionId.isEmpty()) {
      val transactionId = ApigeeCallouts.reservePayment(accessToken, amount, backend)
      
      Ok(html.consent.payment.index(Right(accessToken), transactionId, amount, None, backend))
    }
    else {
      val amountReserved = ApigeeCallouts.reservePayment(accessToken, amount, transactionId, backend)
      
      Ok(html.consent.payment.index(Right(accessToken), Right(transactionId), amountReserved.right.get, None, backend))
    }
  }

  def pay(accessToken: String, amount : String, transactionId : String, originalAmountReserved : String, backend : String) = Action { implicit request =>
      Logger.debug("will call payment for " + amount + " to " + backend);
      
      val amountReserved = ApigeeCallouts.chargePayment(accessToken, amount, transactionId, backend)
      
      Ok(html.consent.payment.index(Right(accessToken), Right(transactionId), 
          if (amountReserved.isRight) { amountReserved.right.get } else { originalAmountReserved }, 
          Some(amountReserved.isRight), backend))
  }

}