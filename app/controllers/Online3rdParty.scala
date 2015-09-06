package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.net.{URI, URLDecoder, URLEncoder}
import models.User
import views._
import scala.util.Random

object Online3rdParty extends Controller {
  val rnd = new Random()  
  def index(backend : String) = Action { implicit request =>
    val client_id = Play.current.configuration.getString(backend + ".online3rdparty.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".online3rdparty.redirect_uri").get

    Ok(html.consent.online3rdparty.index(backend, redirect_uri, client_id, None))
  }
  
  def consentCallback(backend : String) = Action { implicit request =>
    val code = request.getQueryString("code").getOrElse("NULL")
    val redirectUri = Play.current.configuration.getString(backend + ".online3rdparty.redirect_uri").get
    val authHeader = Play.current.configuration.getString(backend + ".online3rdparty.auth_header").get
    val subscriptionsEndpoint = Play.current.configuration.getString(backend + ".subscriptions_endpoint").get

    val accessToken = ApigeeCallouts.getToken(code, redirectUri, authHeader, backend)
    
    if (accessToken.isRight) {
      val redirectUriContracts = Play.current.configuration.getString(backend + ".online3rdparty.redirect_uri_subscriptions").get
      val state = rnd.alphanumeric.take(10).mkString
      Redirect(subscriptionsEndpoint+"&access_token="+URLEncoder.encode(accessToken.right.get, "UTF-8")+"&redirect_uri="+URLEncoder.encode(redirectUriContracts, "UTF-8")+"&state="+URLEncoder.encode(state, "UTF-8")+"&lang=en").withSession(
        session + ("accessToken.online3rdparty" -> accessToken.right.get)
      )
    }
    else {
      val client_id = Play.current.configuration.getString(backend + ".online3rdparty.client_id").get

      Ok(html.consent.online3rdparty.index(backend, redirectUri, client_id, Some("Error getting access token - " + accessToken.left.get)))
    }
  }
  
  def subscription(backend : String) = Action { implicit request =>
    val subscriptionKey = request.getQueryString("subscriptionKey")
    val msisdn = request.getQueryString("msisdn")
    val productName = request.getQueryString("productName");
    
    val client_id = Play.current.configuration.getString(backend + ".online3rdparty.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".online3rdparty.redirect_uri").get
    
    if (!subscriptionKey.isDefined) {    
      Ok(html.consent.online3rdparty.index(backend, redirect_uri, client_id, Some("error getting subscription key: "+request.getQueryString("error").getOrElse("unknown"))))
    }
    else if (!msisdn.isDefined) {
      Ok(html.consent.online3rdparty.index(backend, redirect_uri, client_id, Some("msisdn not received.")))
    }
    else if (!productName.isDefined) {
      Ok(html.consent.online3rdparty.index(backend, redirect_uri, client_id, Some("productName not received.")))
    }    
    else {
      Ok(html.consent.online3rdparty.subscription(backend, subscriptionKey.get,msisdn.get, productName.get, None))
    }
  }
  
  def segment(backend : String) = Action { implicit request =>
    val accessToken = session.get("accessToken.online3rdparty").get
    val response = ApigeeCallouts.getSegment(accessToken, backend) match {
      case Right(x) => "Segment: " + x
      case Left(x) => "ERROR: " + x 
    }
    Ok("{\"response\":\""+response+"\"}").as("text/javascript")
  }
  
  def birthdate(backend : String) = Action { implicit request =>    
    val accessToken = session.get("accessToken.online3rdparty").get
    val response = ApigeeCallouts.getBirthdate(accessToken, backend) match {
      case Right(x) => "Birthdate: " + x
      case Left(x) => "ERROR: " + x 
    }
    Ok("{\"response\":\""+response+"\"}").as("text/javascript")
  }
  
  def simcards(subscriptionKey : String, backend : String) = Action { implicit request =>    
    val accessToken = session.get("accessToken.online3rdparty").get
    val response = ApigeeCallouts.getSimcards(accessToken, subscriptionKey, backend) match {
      case Right(x) => x
      case Left(x) => "ERROR: " + x 
    }
    Ok("{\"response\":\""+response+"\"}").as("text/javascript")
  }
  
  def retention(subscriptionKey : String, backend : String) = Action { implicit request =>   
    val language = request.getQueryString("language").get
    val channel = request.getQueryString("channel").get
    val accessToken = session.get("accessToken.online3rdparty").get
    val response = ApigeeCallouts.getRetention(accessToken, subscriptionKey, language, channel, backend) match {
      case Right(x) => "Retention: " + x
      case Left(x) => "ERROR: " + x 
    }
    Ok("{\"response\":\""+response+"\"}").as("text/javascript")
  }
  
  def eligibility(subscriptionKey : String, backend : String) = Action { implicit request =>    
    val isDeviceWithoutVZ = request.getQueryString("isDeviceWithoutVZ").get
    val useCase = request.getQueryString("useCase").get
    val channel = request.getQueryString("channel").get
    val segment = request.getQueryString("segment").get
    val deviceId = request.getQueryString("deviceId").get
    val accessToken = session.get("accessToken.online3rdparty").get
    val response = ApigeeCallouts.getEligibility(accessToken, subscriptionKey, isDeviceWithoutVZ, useCase, channel, deviceId, segment, backend) match {
      case Right(x) => "Eligibility: " + x
      case Left(x) => "ERROR: " + x 
    }
    Ok("{\"response\":\""+response+"\"}").as("text/javascript")
  }
  
  def order(subscriptionKey : String, backend : String) = Action { implicit request =>    
    val externalUserLoginId = request.getQueryString("externalUserLoginId").get
    val dealerId = request.getQueryString("dealerId").get
    val deviceId = request.getQueryString("deviceId").get
    val commitmentPeriod = request.getQueryString("commitmentPeriod").get
    val useCase = request.getQueryString("useCase").get
    val simTechnology = request.getQueryString("simTechnology").get
    val AppleCare = request.getQueryString("AppleCare").get
    val channel = request.getQueryString("channel").get
    val context = request.getQueryString("context").get
    val productName = request.getQueryString("productName").get
    val newContractStartDate = request.getQueryString("newContractStartDate").get
    val language = request.getQueryString("language").get
    val contactChannel = request.getQueryString("contactChannel").get
    val cellularPhoneNumber = request.getQueryString("cellularPhoneNumber").get
    val emailAddress = request.getQueryString("emailAddress").get
    val firstName = request.getQueryString("firstName").get
    val lastName = request.getQueryString("lastName").get
    val title = request.getQueryString("title").get
    val originIpAddress = request.getQueryString("originIpAddress").get
    
    val accessToken = session.get("accessToken.online3rdparty").get
    
    val response = ApigeeCallouts.newOrder(accessToken, subscriptionKey, externalUserLoginId, dealerId, commitmentPeriod, deviceId, useCase, 
        simTechnology, AppleCare, channel, productName, context, newContractStartDate, language, contactChannel, 
        cellularPhoneNumber, emailAddress, firstName, lastName, title, originIpAddress, backend) match {
      case Right(x) => "Order Id: " + x
      case Left(x) => "ERROR: " + x 
    }
    Ok("{\"response\":\""+response+"\"}").as("text/javascript")
  }

}