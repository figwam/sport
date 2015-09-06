package controllers

import scala.util.{ Try, Success, Failure }
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import models.JsonAddress
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms._
import play.api.libs.ws.Response
import play.api.libs.ws.WS
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.libs.json._
import play.api.libs.functional.syntax._
import views.html
import models._
import com.fasterxml.jackson.core.JsonParseException
import scala.util.control.NonFatal
import play.api.Play
import java.net._
import java.io._

object ApigeeCallouts extends Controller {

  def getToken(code: String, redirectUri: String, authHeader: String, backend : String): Either[String, String] = {
    Logger.info("Get token with auth code " + code)
    try {
      val tokenEndpoint = Play.current.configuration.getString(backend + ".token_endpoint").get

      Logger.info("getToken to backend " + tokenEndpoint)

      val promise = WS.url(tokenEndpoint)
        .withQueryString("grant_type" -> "authorization_code")
        .withQueryString("code" -> code)
        .withQueryString("redirect_uri" -> redirectUri)
        .withHeaders("Authorization" -> ("Basic " + authHeader))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .get()

      val response = awaitResult(promise)

      Logger.debug("response getting token: " + response.body)
      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val access_token = json \ "access_token"
        Right(access_token.as[String])
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting token: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting token: " + e
        Logger.error(error)
        Left(error)
      }
    }
  }

  def getTokenWithClientCredential(): Either[String, String] = {
    Logger.info("Get token with client credentials")
    try {
      val tokenEndpoint = Play.current.configuration.getString("mobile.capacities.token_endpoint").get
      val auth_header = Play.current.configuration.getString("mobile.capacities.auth_header").get

      Logger.info("getToken to backend " + tokenEndpoint)

      val promise = WS.url(tokenEndpoint)
        .withHeaders("Authorization" -> ("Basic " + auth_header))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .withHeaders("Content-Type" -> "application/x-www-form-urlencoded")
        .post("grant_type=client_credentials")

      val response = awaitResult(promise)

      Logger.debug("response getting token: " + response.body)
      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val access_token = json \ "access_token"
        Right(access_token.as[String])
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting token: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting token: " + e
        Logger.error(error)
        Left(error)
      }
    }
  }
    
  def getTokenInfo(oAuthToken: String, backend : String): Either[String, String] = {
    Logger.info("Get token info for oauth token: " + oAuthToken)
    try {
      val tokenInfoEndpoint = Play.current.configuration.getString(backend + ".consenttoken.token_info_uri").get
      
      Logger.info("getTokenInfo to backend " + tokenInfoEndpoint)
      
      val promise = WS.url(tokenInfoEndpoint)
        .withQueryString("access_token" -> oAuthToken)
        .get()
        
      val response = awaitResult(promise)
      
      Logger.debug("response getting token info: " + response.body)
      val json = Json.parse(response.body)
      
      val error_code = (json \ "code").asOpt[String]
      if (error_code.isEmpty) {
        Right(json.toString())
      } else {
        val error_description = (json \ "error_description").asOpt[String]
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting token info: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting token info: " + e
        Logger.error(error)
        Left(error)
      }
    }
  }
  
  def getO365Token(code: String, redirectUri: String, authHeader: String, backend : String): Either[String, String] = {
    Logger.info("Get token with auth code " + code)
    try {
      val tokenEndpoint = Play.current.configuration.getString(backend + ".token_endpoint").get

      Logger.info("getToken to backend " + tokenEndpoint)
      
      var queryString = "?grant_type=authorization_code"
      queryString = queryString + "&code="+code
      queryString = queryString + "&redirect_uri="+redirectUri

      val authorizationHeader = "Basic "+authHeader
      val acceptHeader = "application/json; charset=utf-8"
      val response = executeGet(tokenEndpoint+queryString, authorizationHeader, acceptHeader)

      Logger.debug("response getting token: \n" + response)
      
      val json = Json.parse(response)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      return Right("J89sjJUs8uf")

      if (error_code.isEmpty) {
        val access_token = json \ "access_token"
        Right(access_token.as[String])
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting token: " + errorMessage)
        Left(errorMessage)
      }
      
      val access_token = "access_token"
      Right(access_token)
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting token: " + e
        Logger.error(error)
        Left(error)
      }
    }
  }
  
  
  def executeGet(targetURL: String, authorizationHeader:String, acceptHeader:String) : String = {
    var connection : HttpURLConnection = null
    try {
      val url  = new URL(targetURL)
      var connection = url.openConnection().asInstanceOf[HttpURLConnection]
      connection.setRequestMethod("GET")
      connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded")
      connection.setRequestProperty("Authorization",authorizationHeader)
      connection.setRequestProperty("Accept",acceptHeader);
      connection.setRequestProperty("Content-Language", "en-US");  

      connection.setUseCaches (false);
      connection.setDoInput(true);
      connection.setDoOutput(true);
      
      val is = connection.getInputStream();
      val rd = new BufferedReader(new InputStreamReader(is));
      val response = new StringBuffer(); 
      var line = rd.readLine()
      while(line != null) {
        response.append(line);
        response.append('\n');
        line = rd.readLine()
      }
      rd.close();

      Logger.info("nach close")
      
      //Get Resonse
      return response.toString();
    } catch {
      case NonFatal(e) => {
        val error = "Some other error getting address: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
    }
    return "test"
    
  }
  
  def getBasicProfile(accessToken: String, backend : String): Either[String, BasicProfile] = {
      Logger.info("Get basic profile with access token " + accessToken)
      try {
        val basicprofile_endpoint = Play.current.configuration.getString(backend + ".basicprofile_endpoint").get
            
        Logger.info("getBasicProfile to backend " + basicprofile_endpoint)

            val promise = WS.url(basicprofile_endpoint)
            .withHeaders("Authorization" -> ("Bearer " + accessToken))
            .withHeaders("Accept" -> "application/json; charset=utf-8")
            .get()
            
            val response = awaitResult(promise)
            
            Logger.debug("response getting basic profile: " + response.body)
            
            val json = Json.parse(response.body)
            
            val error_code = (json \ "code").asOpt[String]
        val error_description = (json \ "error_description").asOpt[String]
        
        if (error_code.isEmpty) {
          val firstName = (json \ "firstName").asOpt[String]
          val lastName = (json \ "lastName").asOpt[String]
          val language = (json \ "language").asOpt[String]
          
          Right(BasicProfile(firstName, lastName, language))
        } else {
          val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
              Logger.error("error getting basic profile: " + errorMessage)
              Left(errorMessage)
        }
      } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting basic profile: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
      }
  }
  
  def getAddress(accessToken: String, backend : String): Either[String, JsonAddress] = {
    Logger.info("Get address with access token " + accessToken)
    try {
      val addressEndpoint = Play.current.configuration.getString(backend + ".address_endpoint").get
      Logger.info("addressEndpoint to backend " + addressEndpoint)

      val promise = WS.url(addressEndpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .get()

      val response = awaitResult(promise)

      Logger.debug("response getting address: " + response.body)

      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val streetAddress = (json \ "address" \ "streetAddress").asOpt[String]
        val city = (json \ "address" \ "city").asOpt[String]
        val postalCode = (json \ "address" \ "postalCode").asOpt[String]
        val houseNumber = (json \ "address" \ "houseNumber").asOpt[String]
        val country = (json \ "address" \ "country").asOpt[String]
        val houseName = (json \ "address" \ "houseName").asOpt[String]

        Right(JsonAddress(streetAddress, houseNumber, city, postalCode, country, houseName))
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting address: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting address: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
    }
  }

  def reservePayment(accessToken: String, amount: String, backend : String): Either[String, String] = {
    Logger.info("Reserve payment with access token " + accessToken + " and amount " + amount)
    try {
      val paymentReservationEndpoint = Play.current.configuration.getString(backend + ".payment_endpoint").get
      Logger.info("paymentReservationEndpoint to backend " + paymentReservationEndpoint)

      val jsonRequest: JsValue = JsObject(Seq(
        "amountReservationTransaction" -> JsObject(Seq(
          "clientCorrelator" -> JsString("6255918905"),
          "endUserId" -> JsString("acr:Authorization"),
          "paymentAmount" -> JsObject(Seq(
            "chargingInformation" -> JsObject(Seq(
              "amount" -> JsString(amount),
              "currency" -> JsString("CHF"),
              "description" -> JsString("Streaming video of the big fight"))),
            "chargingMetaData" -> JsObject(Seq(
              "onBehalfOf" -> JsString("Example Video Inc"),
              "purchaseCategoryCode" -> JsString("Video"),
              "channel" -> JsString("WAP"),
              "taxAmount" -> JsString("0"))))),
          "referenceCode" -> JsString("REF-n3btj"),
          "referenceSequence" -> JsString("1"),
          "transactionOperationStatus" -> JsString("Reserved")))))

      Logger.debug("request reserving amount (" + paymentReservationEndpoint + "): " + jsonRequest)

      val promise = WS.url(paymentReservationEndpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .post(jsonRequest)

      val response = awaitResult(promise)

      Logger.debug("response reserving amount: " + response.body)

      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val resourceURL = (json \ "amountReservationTransaction" \ "resourceURL").asOpt[String]

        Right(resourceURL.get.substring(resourceURL.get.lastIndexOf('/') + 1))
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error reserving amount: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error reserving amount: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
    }
  }

  def reservePayment(accessToken: String, amount: String, transactionId: String, backend : String): Either[String, String] = {
    Logger.info("Reserve payment with access token " + accessToken + " and amount " + amount + " and transactionId " + transactionId)
    try {
      val paymentReservationEndpoint = Play.current.configuration.getString(backend + ".payment_endpoint").get + "/" + transactionId
      Logger.info("paymentReservationEndpoint to backend " + paymentReservationEndpoint)

      val jsonRequest: JsValue = JsObject(Seq(
        "amountReservationTransaction" -> JsObject(Seq(
          "endUserId" -> JsString("acr:Authorization"),
          "paymentAmount" -> JsObject(Seq(
            "chargingInformation" -> JsObject(Seq(
              "amount" -> JsString(amount),
              "currency" -> JsString("CHF"),
              "description" -> JsString("Streaming video of the big fight"))))),
          "referenceCode" -> JsString("REF-n3btj"),
          "referenceSequence" -> JsString("1"),
          "transactionOperationStatus" -> JsString("Reserved")))))

      Logger.debug("request reserving amount (" + paymentReservationEndpoint + "): " + jsonRequest)

      val promise = WS.url(paymentReservationEndpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .post(jsonRequest)

      val response = awaitResult(promise)

      Logger.debug("response reserving amount: " + response.body)

      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val amountReserved = (json \ "amountReservationTransaction" \ "paymentAmount" \ "amountReserved").asOpt[String]

        Right(amountReserved.get)
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error reserving amount: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error reserving amount: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
    }
  }

  def chargePayment(accessToken: String, amount: String, transactionId: String, backend : String): Either[String, String] = {
    Logger.info("Charge payment with access token " + accessToken + " and amount " + amount + " and transactionId " + transactionId)
    try {
      val paymentChargeEndpoint = Play.current.configuration.getString(backend + ".payment_endpoint").get + "/" + transactionId
      Logger.info("paymentChargeEndpoint to backend " + paymentChargeEndpoint)

      val jsonRequest: JsValue = JsObject(Seq(
        "amountReservationTransaction" -> JsObject(Seq(
          "endUserId" -> JsString("acr:Authorization"),
          "paymentAmount" -> JsObject(Seq(
            "chargingInformation" -> JsObject(Seq(
              "amount" -> JsString(amount),
              "currency" -> JsString("CHF"),
              "description" -> JsString("Payment roberto.ch"))))),
          "referenceCode" -> JsString("REF-n3btj"),
          "referenceSequence" -> JsString("1"),
          "transactionOperationStatus" -> JsString("Charged")))))

      Logger.debug("request charging amount (" + paymentChargeEndpoint + "): " + jsonRequest)

      val promise = WS.url(paymentChargeEndpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .post(jsonRequest)

      val response = awaitResult(promise)

      Logger.debug("response charging amount: " + response.body)

      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val amountReserved = (json \ "amountReservationTransaction" \ "paymentAmount" \ "amountReserved").asOpt[String]

        Right(amountReserved.get)
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error charging amount: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error charging amount: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
    }
  }
  
  def getSegment(accessToken: String, backend : String): Either[String, String] = {
      Logger.info("Get segment with access token " + accessToken)
      try {
        val endpoint = Play.current.configuration.getString(backend + ".segment_endpoint").get
            
            Logger.info("get segment to endpoint " + endpoint)
            
            val promise = WS.url(endpoint)
            .withHeaders("Authorization" -> ("Bearer " + accessToken))
            .withHeaders("Accept" -> "application/json; charset=utf-8")
            .get()
            
            val response = awaitResult(promise)
            
            Logger.debug("response getting segment: " + response.body)
            
            val json = Json.parse(response.body)
            
            val error_code = (json \ "code").asOpt[String]
                val error_description = (json \ "error_description").asOpt[String]
                    
                    if (error_code.isEmpty) {
                      val segment = (json \ "segment").asOpt[String]
                          if (!segment.isDefined) {
                            Left("No segment in response: " + response.body)
                          }
                          else {
                            Right(segment.get)
                          }
                    } else {
                      val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
                          Logger.error("error getting segment: " + errorMessage)
                          Left(errorMessage)
                    }
      } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting segment: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
      }
  }
  
  def getBirthdate(accessToken: String, backend : String): Either[String, String] = {
      Logger.info("Get birthdate with access token " + accessToken)
      try {
        val endpoint = Play.current.configuration.getString(backend + ".birthdate_endpoint").get
            
            Logger.info("get birthdate to endpoint " + endpoint)
            
            val promise = WS.url(endpoint)
            .withHeaders("Authorization" -> ("Bearer " + accessToken))
            .withHeaders("Accept" -> "application/json; charset=utf-8")
            .get()
            
            val response = awaitResult(promise)
            
            Logger.debug("response getting birthdate: " + response.body)
            
            val json = Json.parse(response.body)
            
            val error_code = (json \ "code").asOpt[String]
                val error_description = (json \ "error_description").asOpt[String]
                    
                    if (error_code.isEmpty) {
                      val birthdate = (json \ "birthdate").asOpt[String]
                          if (!birthdate.isDefined) {
                            Left("No birthdate in response: " + response.body)
                          }
                          else {
                            Right(birthdate.get)
                          }
                    } else {
                      val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
                          Logger.error("error getting birthdate: " + errorMessage)
                          Left(errorMessage)
                    }
      } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting birthdate: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
      }
  }

  def getSimcards(accessToken: String, subscriptionKey : String, backend : String): Either[String, String] = {
      Logger.info("Get Simcards with access token " + accessToken + " and subscriptionKey " + subscriptionKey)
      try {
        val endpoint = Play.current.configuration.getString(backend + ".simcards_endpoint").get
            
            Logger.info("get Simcards to endpoint " + endpoint)
            
            val promise = WS.url(endpoint)
            .withQueryString("subscriptionKey" -> subscriptionKey)
            .withHeaders("Authorization" -> ("Bearer " + accessToken))
            .withHeaders("Accept" -> "application/json; charset=utf-8")
            .get()
            
            val response = awaitResult(promise)
            
            Logger.debug("response getting Simcards: " + response.body)
            
            val json = Json.parse(response.body) 
   
            implicit val simcardReader: Reads[(String, String, String)] = (
              (__ \ "IMSI").read[String] and 
              (__ \ "type").read[String] and
              (__ \ "HLR").read[String]  
            ).tupled
            val simcards = json.as[List[(String, String, String)]]
      
            
            val error_code = (json \ "code").asOpt[String]
            val error_description = (json \ "error_description").asOpt[String]         
            var output = "Simcards: </br>";
            for( simcard <- simcards){
              output = output + "- IMSI: " + simcard._1 + ", type: " + simcard._2 + ", HLR: " + simcard._3 + "</br>";
            }
            if (error_code.isEmpty) {   
              Right(output)  
            } else {
              val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
                  Logger.error("error getting simcards: " + errorMessage)
                  Left(errorMessage)
            }
      } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting simcards: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
      }
  }
  
  def getRetention(accessToken: String, subscriptionKey : String, language : String, channel : String, backend : String): Either[String, String] = {
      Logger.info("Get retention with access token " + accessToken + " and subscriptionKey " + subscriptionKey + " and language " + language)
      try {
        val endpoint = Play.current.configuration.getString(backend + ".retention_endpoint").get
            
            Logger.info("get retention to endpoint " + endpoint)
            
            val promise = WS.url(endpoint)
            .withQueryString("subscriptionKey" -> subscriptionKey)
            .withQueryString("language" -> language)
            .withQueryString("channel" -> channel)
            .withHeaders("Authorization" -> ("Bearer " + accessToken))
            .withHeaders("Accept" -> "application/json; charset=utf-8")
            .get()
            
            val response = awaitResult(promise)
            
            Logger.debug("response getting retention: " + response.body)
            
            val json = Json.parse(response.body)
            
            val error_code = (json \ "code").asOpt[String]
                val error_description = (json \ "error_description").asOpt[String]
                    
                    if (error_code.isEmpty) {
                      Right(
                          "reasonCode: " + (json \ "reasonCode").asOpt[String].getOrElse("unknown") + "<br/>" +
                          "reasonText: " + (json \ "reasonText").asOpt[String].getOrElse("unknown").replace("\n", "\\n") + "<br/>" +
                          "trafficLight: " + (json \ "trafficLight").asOpt[String].getOrElse("unknown") + "<br/>" +
                          "bonusGroup: " + (json \ "bonusGroup").asOpt[String].getOrElse("unknown") + "<br/>" +
                          "aboGroup: " + (json \ "aboGroup").asOpt[String].getOrElse("unknown") + "<br/>" +
                          "daysUntilOffer: " + (json \ "daysUntilOffer").asOpt[String].getOrElse("unknown") + "<br/>" +
                          "subscriptionEndDate: " + (json \ "subscriptionEndDate").asOpt[String].getOrElse("unknown") + "<br/>" +
                          "proposedSubscriptionStartDate: " + (json \ "proposedSubscriptionStartDate").asOpt[String].getOrElse("unknown")
                          )
                    } else {
                      val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
                          Logger.error("error getting retention: " + errorMessage)
                          Left(errorMessage)
                    }
      } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting retention: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
      }
  }
  
  def getEligibility(accessToken : String, subscriptionKey : String, isDeviceWithoutVZ : String, useCase : String, channel : String, deviceId : String, segment : String, backend : String): Either[String, String] = {
      Logger.info("Get eligibility with access token " + accessToken + " and subscriptionKey " + subscriptionKey)
      try {
        val endpoint = Play.current.configuration.getString(backend + ".eligibility_endpoint").get
            
            Logger.info("get eligibility to endpoint " + endpoint)
            
            val promise = WS.url(endpoint)
            .withQueryString("subscriptionKey" -> subscriptionKey)
            .withQueryString("isDeviceWithoutVZ" -> isDeviceWithoutVZ)
            .withQueryString("useCase" -> useCase)
            .withQueryString("channel" -> channel)
            .withQueryString("segment" -> segment)
            .withQueryString("deviceId" -> deviceId)
            .withHeaders("Authorization" -> ("Bearer " + accessToken))
            .withHeaders("Accept" -> "application/json; charset=utf-8")
            .get()

            val response = awaitResult(promise)
            
            Logger.debug("response getting eligibility: " + response.body)
            
            val json = Json.parse(response.body)
            
            Logger.debug("json parsed: " + json)

            val error_code = (json \ "code").asOpt[String]
                val error_description = (json \ "error_description").asOpt[String]
                    
                    if (error_code.isEmpty) {
                      
                      val productNames = (json \ "devices" \\ "productName").mkString(",").split(",")
                      
                      Right(
                          ("deviceIds: " + (json \ "devices" \\ "deviceId").distinct.mkString(",") + "<br/>" 
                          + "productNames: " + (json \ "devices" \\ "productName").distinct.mkString(",") + "<br/>" 
                          + "commitmentPeriods: " + (json \ "devices" \\ "commitmentPeriods").distinct.mkString(",")
                          ).replace("\"", "\\\"")
                          )                          
                    } else {
                      val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
                          Logger.error("error getting eligibility: " + errorMessage)
                          Left(errorMessage)
                    }
      } catch {
      case e: JsonParseException => Left("Error parsing JSON Response: "+e.getMessage)
      case NonFatal(e) => {
        val error = "Some other error getting eligibility: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
      }
  }
  
  def chargePayment(accessToken : String, backend : String, amount: String): String = {
    val endpoint = Play.current.configuration.getString(backend + ".payments_endpoint").get
    
    val bodyJson = Json.obj(
        "requestId" -> "a2",
        "products" -> Json.arr(
            Json.obj(
              "vatId" -> "D0",
              "amount" -> amount,
              "text" -> "Some text." 
            )
        )
    )
    
    val bodyJsonString = Json.stringify(bodyJson)
    
    val promise = WS.url(endpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .withHeaders("Content-Type" -> "application/json")
        .post(bodyJsonString)
      
    val response = awaitResult(promise)
     response.body.isEmpty()
    val json: String = response.body
    return json
  }

  def newOrder(accessToken : String, subscriptionKey : String, externalUserLoginId : String, dealerId : String, commitmentPeriod : String, deviceId : String, useCase : String, 
      simTechnology : String, AppleCare : String, channel : String, productName : String,
      context : String, newContractStartDate : String, language : String, contactChannel : String, cellularPhoneNumber : String,
      emailAddress : String, firstName : String, lastName : String, title : String, originIpAddress : String, backend : String): Either[String, String] = {
    Logger.info("Post order with access token " + accessToken + " and subscriptionKey " + subscriptionKey)
    try {
      val endpoint = Play.current.configuration.getString(backend + ".orders_endpoint").get
      
      val bodyJson = Json.obj(
          "externalUserLoginId" -> externalUserLoginId,
          "dealerId" -> dealerId,
          "commitmentPeriod" -> commitmentPeriod,
          "deviceId" -> deviceId,
          "useCase" -> useCase,
          "simTechnology" -> simTechnology,
          "AppleCare" -> AppleCare,
          "channel" -> channel,
          "productName" -> productName,
          "context" -> context,
          "newContractStartDate" -> newContractStartDate,
          "language" -> language,
          "originIpAddress" -> originIpAddress,
          "oneTimeContact" -> Json.obj(          
            "contactChannel" -> contactChannel,
            "cellularPhoneNumber" -> cellularPhoneNumber,
            "emailAddress" -> emailAddress,
            "firstName" -> firstName,
            "lastName" -> lastName,
            "title" -> title
            )
          )
        
      val bodyJsonString = Json.stringify(bodyJson)
      
      Logger.info("post order to endpoint " + endpoint+" "+bodyJsonString)

      val promise = WS.url(endpoint)
        .withQueryString("subscriptionKey" -> subscriptionKey)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .withHeaders("Content-Type" -> "application/json")
        .post(bodyJsonString)
      
      val response = awaitResult(promise)
      
      Logger.debug("response posting order: " + response.body)
      
      val json = Json.parse(response.body)
      
      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]
      
      if (error_code.isEmpty) {
        val srIntegrationId = (json \ "srIntegrationId").asOpt[String]
        Right(srIntegrationId.getOrElse("not found"))
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error posting order: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
    case e: JsonParseException => Left("Error parsing JSON Response")
    case NonFatal(e) => {
      val error = "Some other error posting order: " + e.getMessage
      Logger.error(error)
      Left(error)
    }
    }
  }

  def paymentTransactions(accessToken : String, backend : String): Either[String, JsValue] = {
    Logger.info("Get transactions with access token " + accessToken)
    try {
      val endpoint = Play.current.configuration.getString(backend + ".paymentv2.transactions.endpoint").get

      val promise = WS.url(endpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .withHeaders("Content-Type" -> "application/json")
        .get()

      val response = awaitResult(promise)

      Logger.debug("response posting order: " + response.body)

      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        Right(json)
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting the transactions: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error while getting the transactions: " + e.getMessage
        Logger.error(error)
        Left(error)
      }
    }
  }

  /**
   * Invokes transactions.amount endpoint for payment/refund.
   *
   * @param accessToken for authorization of endpoint invocation
   * @param paymentData data for the request
   * @param backend type of backend: local/int/ext
   * @param transactionOperationStatus value for the request: charged/refunded
   *
   * @return Tuple2(request body, response body)
   */
  def paymentTransactionPay(accessToken : String, paymentData: PaymentData, backend : String, transactionOperationStatus: String): Tuple2[String, String] = {
    val requestBodyJson = Json.obj(
      "amountTransaction" -> Json.obj(
        "endUserId" -> paymentData.endUserId,
        "paymentAmount" -> Json.obj(
          "chargingInformation" -> Json.obj(
            "amount" -> paymentData.amount,
            "currency" -> paymentData.currency,
            "description" -> Json.arr(paymentData.description, "additional automatic description"),
            "locale" -> Json.arr(paymentData.locale)
          ),
          "chargingMetaData" -> Json.obj(
            "onBehalfOf" -> paymentData.onBehalfOf,
            "purchaseCategoryCode" -> paymentData.purchaseCategoryCode,
            "taxRate" -> paymentData.taxRate
          )
        ),
        "referenceCode" -> paymentData.referenceCode,
        "transactionOperationStatus" -> transactionOperationStatus
      )
    )

    val requestBodyJsonString = requestBodyJson.toString()

    try {
      val endpoint = Play.current.configuration.getString(backend + ".paymentv2.transactions.payment.endpoint").get
      Logger.info("Apigee endpoint for payment: " + endpoint)
      val eventualResponse = WS.url(endpoint)
        .withHeaders("Authorization" -> ("Bearer " + accessToken))
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .withHeaders("Content-Type" -> "application/json")
        .post(requestBodyJsonString)

      val response = awaitResult(eventualResponse)

      Logger.debug("response transactions/amount: " + response.body)

      //val result = Json.parse(response.body)
      val responseBodyJsonString = response.body
      return new Tuple2(requestBodyJsonString, responseBodyJsonString)
    } catch {
      case NonFatal(e) => {
        val err = ("unexpected error " + e).replace("\n", "\\n").replace("\"", "\\\"")
        return new Tuple2(requestBodyJsonString, "{\"error\": \"" + err + "\"}")
      }
    }
  }

  def getDeviceLocation(access_token: String, msisdn: String, backend: String): Either[String, String] = {
    Logger.info("Get device location with access token: " + access_token)
    try {
      val basePath = Play.current.configuration.getString(backend + ".location.devices.endpoint").get
      val client_id = Play.current.configuration.getString(backend + ".location.client_id").get

      val endPoint = basePath + msisdn + "/roaming"
      Logger.info("Apigee endpoint for location/devices: " + endPoint)

      val responsePromise = WS.url(endPoint)
        .withHeaders("Authorization" -> ("Bearer " + access_token))
        .withHeaders("Accept" -> "application/json;charset=utf-8")
        .get()

      val response = awaitResult(responsePromise)
      // Force JSON parsing so it generates an exception for an invalid answer
      // There is no error code in the JSON that we have to check so if the
      // answer is valid JSON it's always success
      val json = Json.parse(response.body)
      Logger.debug("Response from location/devices: " + response.body)
      Right(response.body.replace("\n", "\\n").replace("\"", "\\\""))
    } catch {
      case e: JsonParseException => Left("Error parsing JSON response")
      case NonFatal(e) => {
        val error = "Unexpected error while receiving device location: " + e
        Logger.error(error)
        Left(error)
      }
    }
  }

  def getMobileCapacity(access_token: String): Either[String, String] = {
    Logger.info("Get mobile capacities")
    try {
      val capacitiesEndpoint = Play.current.configuration.getString("mobile.capacities.endpoint").get
      val client_id = Play.current.configuration.getString("mobile.capacities.client_id").get
      
      Logger.info("getMobileCapacities to backend " + capacitiesEndpoint)

      val promise = WS.url(capacitiesEndpoint)
        .withQueryString("ip" -> "10.0.0.10")
        .withHeaders("Authorization" -> ("Bearer " + access_token))
        .withHeaders("client_id" -> client_id)
        .withHeaders("Accept" -> "application/json; charset=utf-8")
        .withHeaders("Content-Type" -> "application/json; charset=utf-8")
        .get()

      val response = awaitResult(promise)

      Logger.debug("response getting token: " + response.body)
      val json = Json.parse(response.body)

      val error_code = (json \ "code").asOpt[String]
      val error_description = (json \ "error_description").asOpt[String]

      if (error_code.isEmpty) {
        val capacities = json.toString()
        Right(capacities)
      } else {
        val errorMessage = error_description.getOrElse("") + " [" + error_code.get + "]"
        Logger.error("error getting mobile capacities: " + errorMessage)
        Left(errorMessage)
      }
    } catch {
      case e: JsonParseException => Left("Error parsing JSON Response")
      case NonFatal(e) => {
        val error = "Some other error getting mobile capacities: " + e
        Logger.error(error)
        Left(error)
      }
    }
  }    
  
  protected def awaitResult(future: Future[Response]) = {
    Await.result(future, secondsToWait)
  }

  val secondsToWait = {
    import scala.concurrent.duration._
    30.seconds
  }
}