package controllers

import scala.util.{ Try, Success, Failure }
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import scala.util.control.Exception._
import models.Sms
import play.api.Logger
import play.api.data._
import play.api.data.Forms._
import play.api.data.Forms.mapping
import play.api.data.Forms.nonEmptyText
import play.api.libs.ws.Response
import play.api.libs.ws.WS
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.Play
import views.html
import models._
import play.api.Routes

object ConsentVerifyAddress extends Controller {

  val vaForm: Form[VAUser] = Form(
    // Define a mapping that will handle User values
    mapping(
      "name" -> nonEmptyText,
      "firstname" -> nonEmptyText,
      "country" -> nonEmptyText,
      "city" -> nonEmptyText,
      "street" -> nonEmptyText,
      "housenr" -> nonEmptyText,
      "zip" -> nonEmptyText)(VAUser.apply)(VAUser.unapply))

  def index(backend: String, response_type: String, app : String) = Action { implicit request =>

    val client_id = if (!backend.equals("mock")) Play.current.configuration.getString(backend + "." + app + ".client_id") else None
    val redirect_uri = if (!backend.equals("mock")) Play.current.configuration.getString(backend + "." + app + ".redirect_uri") else None

    Ok(html.consent.verifyaddress.index(backend, response_type, client_id.getOrElse(""), redirect_uri.getOrElse("") + "&backend="+backend, app));
  }

  def form = Action { implicit request =>
    val backend = request.getQueryString("backend").getOrElse("mock")
    val app = request.getQueryString("app").getOrElse("appless")
    val userGot = user(backend, app, request)
    Ok(html.consent.verifyaddress.form(userGot._1, userGot._2, infoMessage(request.getQueryString("code").getOrElse("NULL").equals("m0Ck32"), userGot._3), backend, userGot._3, app))
  }
 
  def infoMessage(useMock : Boolean, codeOrToken: String) = {
    Some(
        if (useMock) {
            "The form was filled with your address as provided by Swisscom (mocked)."
        }
        else {
          if (codeOrToken.equals("code")) {
            "The form was filled with your name and address as provided by Swisscom."
          }
          else {
            def addressEndpoint = Play.current.configuration.getString("address_endpoint").getOrElse("whatever that is")
            "Client-side code will extract access token (implicit flow). Make sure you accept certificate from "+addressEndpoint+"."
          }})
  }

  def user(backend: String, consent: String, request: play.api.mvc.Request[play.api.mvc.AnyContent]): Tuple3[Option[String], Form[VAUser], String] = {

    val code = request.getQueryString("code").getOrElse("NULL")
    val error = request.getQueryString("error")

    val auth_header = Play.current.configuration.getString(backend + "." + consent + ".auth_header")
    val redirect_uri = Play.current.configuration.getString(backend + "." + consent + ".redirect_uri")

    if (error.isDefined) {
      Tuple3(request.getQueryString("error_description"), vaForm.fill(new VAUser("", "", "", "", "", "", "")), "code")
    } else {
      if (code.equals("m0Ck32")) {
        //mocked
        Tuple3(None, vaForm.fill(new VAUser("Schamne", "Alexander", "Switzerland", "Bern", "Hauptstrasse", "10", "3012")), "code")
      } else if (code.equals("NULL")) {
        //possibly implicit grant (no code, but no error)
        Tuple3(None, vaForm.fill(new VAUser("", "", "", "", "", "", "")), "token")
      } else {
        //auth code grant
        Logger.debug("auth code grant with code: " + code);

        val accessToken = ApigeeCallouts.getToken(code, redirect_uri.get + "&backend=" + backend, auth_header.get, backend)
        if (accessToken.isRight) {
          Logger.debug("got access token: " + accessToken)

          val basicProfile = ApigeeCallouts.getBasicProfile(accessToken.right.get, backend)
          val address = ApigeeCallouts.getAddress(accessToken.right.get, backend)

          var error : Option[String] = None
          
          if (!basicProfile.isRight) {
            error = Some("Error calling user profile API: " + basicProfile.left.get)
          }
          if (!address.isRight) {
            error = Some(error.getOrElse("") + " Error address profile API: " + address.left.get)
          }
          
          Tuple3(error, vaForm.fill(new VAUser(
              basicProfile.fold(l=>"", r=>r.lastName.getOrElse("")), 
              basicProfile.fold(l=>"", r=>r.firstName.getOrElse("")),
              address.fold(l=>"", r=>r.country.getOrElse("")),
              address.fold(l=>"", r=>r.city.getOrElse("")),
              address.fold(l=>"", r=>r.streetAddress.getOrElse("")),
              address.fold(l=>"", r=>r.houseNumber.getOrElse("")),
              address.fold(l=>"", r=>r.postalCode.getOrElse("")))),
              "code")
        } else {
          Tuple3(Some(accessToken.left.get), vaForm.fill(new VAUser("", "", "", "", "", "", "")), "code")
        }
      }
    }
  }

  def submit = Action { implicit request =>
    //does this to get hidden fields (useMock, response_type, isManual) that I didn't want to put on VaUser or use nested objects
    val values = request.body.asFormUrlEncoded

    vaForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.consent.verifyaddress.form(None, formWithErrors, None, formWithErrors.data("backend"), formWithErrors.data("responseType"), formWithErrors.data("app"))),
      user => Redirect(routes.ConsentVerifyAddress.summary(user.firstname, values.get("backend").head, values.get("responseType").head, values.get("app").head))
    )
  }

  def summary(firstName: String, backend: String, response_type: String, app : String) = Action { implicit request =>
    Ok(html.consent.verifyaddress.summary(firstName, backend, response_type, app))
  }

  def getOauthProviders(backend: String, app : String) = Action { implicit request => 
    // Add configuration for one or more providers.
    def clientId = Play.current.configuration.getString(backend + "." + app + ".client_id").getOrElse("no idea")
    def redirectUri = Play.current.configuration.getString(backend + "." + app + ".redirect_uri").getOrElse("no clue")
    def consentEndpoint = Play.current.configuration.getString(backend + ".consent_endpoint").getOrElse("beats me") + (if (app=="manual40" || app=="automatic40") "&RAL=40" else "")
    
    Ok("""
jso_configure({
  "uwap": {
    client_id: "-----",
    redirect_uri: "http://localhost/~andreas/jso/demo/",
    authorization: "http://proxydemo.app.bridge.uninett.no/_/oauth/auth.php/authorization"
  },
  "facebook": {
    client_id: "-----",
    redirect_uri: "http://localhost/~andreas/jso/demo/",
    authorization: "https://www.facebook.com/dialog/oauth",
    presenttoken: "qs"
  },
  "linkedin": {
    client_id: "-----",
    redirect_uri: "http://localhost/~andreas/jso/demo/",
    authorization: "https://www.linkedin.com/oauth"
  },
  "google": {
    client_id: "541950296471-l3c03llam468opj7gljtjav8v13pi0mf.apps.googleusercontent.com",
    redirect_uri: "http://bridge.uninett.no/jso/jso/demo/index.html",
    authorization: "https://accounts.google.com/o/oauth2/auth",
    isDefault: true
  },
  "ibm": {
    client_id: "-----.googleusercontent.com",
    redirect_uri: "http://localhost/~andreas/jso/demo/",
    authorization: "https://accounts.google.com/o/oauth2/auth"
  },
  "instagram": {
    client_id: "xxx",
    redirect_uri: "http://localhost/~andreas/jso/demo/",
    authorization: "https://instagram.com/oauth/authorize/",
    scope: ["basic", "likes"]
  },
  "swisscom": {
    client_id: """"+clientId+"""",
    redirect_uri: """"+redirectUri+"&backend="+backend+"""",
    authorization: """"+consentEndpoint+"?lang=en"+""""
  }
});""").as("text/javascript")
  }

}