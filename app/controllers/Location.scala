package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.net.{URI, URLDecoder, URLEncoder}
import models.User
import views._
import scala.util.Random

object Location extends Controller {
    def index(backend: String) = Action { implicit request =>
        val client_id = Play.current.configuration.getString(backend + ".location.client_id").get
        val redirect_uri = Play.current.configuration.getString(backend + ".location.redirect_uri").get

        Ok(html.consent.location.index(backend, redirect_uri, client_id, None))
    }

    def consentCallback(backend: String) = Action { implicit request =>
        val code = request.getQueryString("code").getOrElse("NULL")
        val redirect_uri = Play.current.configuration.getString(backend + ".location.redirect_uri").get
        val client_id = Play.current.configuration.getString(backend + ".location.client_id").get
        val authHeader = Play.current.configuration.getString(backend + ".location.auth_header").get
        val redirectEndpoint = Play.current.configuration.getString(backend + ".location.redirect_endpoint").get

        val accessToken = ApigeeCallouts.getToken(code, redirect_uri, authHeader, backend)

        if(accessToken.isRight) {
          Redirect(redirectEndpoint).withSession(session + ("accessToken.location" -> accessToken.right.get))
        } else {
        	val client_id = Play.current.configuration.getString(backend + ".location.client_id").get
        	Ok(html.consent.location.index(backend, redirect_uri, client_id, Some("Error getting access token - " + accessToken.left.get)))
        }
    }

    def getDeviceIndex(backend: String) = Action { implicit request => 
        Ok(html.consent.location.device(backend, None))
    }

   	def getDeviceLocation(backend : String) = Action { implicit request =>
   		var msisdn = request.getQueryString("device-msisdn").get
   		val accessToken = session.get("accessToken.location")
      val redirect_uri = Play.current.configuration.getString(backend + ".location.redirect_uri").get
      val client_id = Play.current.configuration.getString(backend + ".location.client_id").get

      accessToken match {
        case Some(accessToken) =>
          val response = ApigeeCallouts.getDeviceLocation(accessToken, msisdn, backend) match {
            case Right(x) => "Location: " + x
            case Left(x) => "ERROR: " + x
          }

          Ok("{\"response\":\"" + response + "\"}").as("application/json")

        case None =>
          Ok("{\"response\": {\"error: \\\"INVALID_ACCESS_TOKEN\\\", advice: \\\"Restart workflow to get a new access token\\\"}\"}").as("application/json")
      }
   	}
}