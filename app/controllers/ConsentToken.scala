package controllers

import java.net.URLEncoder
import javax.xml.bind.DatatypeConverter

import scala.util.control.NonFatal

import play.api._
import play.api.data.Forms._
import play.api.data._
import play.api.libs.json._
import play.api.mvc._
import views._

case class TokenInfo(ClientId: String, ClientSecret: String, Scope: Option[String]/*, Flow: String*/)

/**
 * @author TAASACH1, TAAHOST5
 */
object ConsentToken extends Controller {

  /**
   * Form that specifies the parameters for the token info
   */
  var tokenInfoForm: Form[TokenInfo] = Form(
    // Define a mapping that will handle user values
    mapping(
      "ClientId" -> nonEmptyText,
      "ClientSecret" -> nonEmptyText,
      "Scope" -> optional(text))/*,(TokenInfo.apply)(TokenInfo.unapply))
      "Flow" -> nonEmptyText)*/(TokenInfo.apply)(TokenInfo.unapply))

  var client_id = "unknown"
  var client_secret = "unknown"

  /**
   * Index page that presents the form.
   */
  def index(backend: String) = Action { implicit request =>
    try {
      tokenInfoForm.get
    } catch {
      case NonFatal(e) => {
        val client_id_default = Play.current.configuration.getString(backend + ".consenttoken.client_id").get
        val client_secret_default = Play.current.configuration.getString(backend + ".consenttoken.client_secret").get
        //val flow_default = "true"
        tokenInfoForm = tokenInfoForm.fill(TokenInfo(client_id_default, client_secret_default, None/*, flow_default*/))
      }
    }

    Ok(html.consent.ConsentToken.index(backend, tokenInfoForm, null, None))
  }

  /**
   * Receives the form with parameters and calls the consent server for an access code or token.
   */
  def consentRedirect(backend: String) = Action { implicit request =>
    tokenInfoForm.bindFromRequest.fold(
      formWithErrors => {
        // binding failure, you retrieve the form containing errors
        BadRequest(html.consent.ConsentToken.index(backend, formWithErrors, null, None))
      },
      tokenInfo => {
        val consentEndpoint = Play.current.configuration.getString(backend + ".consent_endpoint").get
        client_id = tokenInfo.ClientId
        client_secret = tokenInfo.ClientSecret

        var scopeParam = "";
        val scope = tokenInfo.Scope
        if (scope.isDefined) {
          scopeParam = "&scope=" + URLEncoder.encode(scope.get)
        }

        //if (tokenInfo.Flow == "true") {
          val redirect_uri = Play.current.configuration.getString(backend + ".consenttoken.code_redirect_uri").get
          Redirect(consentEndpoint + "?response_type=code" + "&client_id=" + URLEncoder.encode(client_id) + "&lang=de" + "&redirect_uri=" + URLEncoder.encode(redirect_uri) + scopeParam)
        /*} else {
          val redirect_uri = Play.current.configuration.getString(backend + ".consenttoken.token_redirect_uri").get
          Redirect(consentEndpoint + "?response_type=token" + "&client_id=" + URLEncoder.encode(client_id) + "&lang=de" + "&redirect_uri=" + URLEncoder.encode(redirect_uri) + scopeParam)
        }*/
      }
    )

  }

  /**
   * Receives the code.
   */
  def consentCallbackResponseTypeCode(backend: String) = Action { implicit request =>
    val code = request.getQueryString("code").getOrElse("NULL")
    val error = request.getQueryString("error")

    if (error.isDefined) {
      Ok(html.consent.ConsentToken.index(backend, tokenInfoForm, null, request.getQueryString("error_description")))
    } else {

      /* Java 8 */
      // val base64authHeader = java.util.Base64.getEncoder.encodeToString((client_id + ":" + client_secret).getBytes(StandardCharsets.UTF_8))

      /* Java 6, 7 */
      val messageUtf8 = (client_id + ":" + client_secret).getBytes("UTF-8");
      val base64authHeader = DatatypeConverter.printBase64Binary(messageUtf8);

      val redirect_uri = Play.current.configuration.getString(backend + ".consenttoken.code_redirect_uri").get

      val accessToken = ApigeeCallouts.getToken(code, redirect_uri, base64authHeader, backend)
      if (accessToken.isLeft) {
        // invalid token
        val errorFromRequestHeader: String = request.getQueryString("error_description").getOrElse("")
        Ok(html.consent.ConsentToken.index(backend, tokenInfoForm, null, Some("Error getting access token - " + accessToken.left.get + (if (errorFromRequestHeader.isEmpty()) "" else ": " + errorFromRequestHeader))))
      } else {
        val result = ApigeeCallouts.getTokenInfo(accessToken.right.get, backend)
        if (result.isLeft) {
          // invalid token info
          Ok(html.consent.ConsentToken.index(backend, tokenInfoForm, null, Some("Error getting token info - " + result.left.get)))
        } else {
          val formatted = formatJSON2HTML(result.right.get, accessToken.right.get)
          Ok(html.consent.ConsentToken.index(backend, tokenInfoForm, formatted, None))
        }
      }
    }
  }

  /**
   * Receives the token.
   */
  def consentCallbackResponseTypeToken(backend: String) = Action { implicit request =>

    Ok(html.consent.ConsentToken.index(backend, tokenInfoForm, "Not yet implemented...", None))
  }

  /**
   * Formats the json result to html
   */
  def formatJSON2HTML(jsonAsString: String, accessToken: String) : String = {
    val json = Json.parse(jsonAsString)
    
    val resType = (json \ "type").toString()
    val resApp = (json \ "application_name").toString()
    val resScope = (json \ "scope").toString()
    val resToken = (json \ "token_type").toString()
    val resIssued = (json \ "issued_at").toString()
    val resExpires = (json \ "expires_in").toString()
    val accessTokenString = '"' + accessToken + '"'
    
    val formatted = "<table width=\"100%\">" + getHTMLRow("Object Type", resType) + getHTMLRow("Application Name", resApp) + getHTMLRow("Scope", resScope) + getHTMLRow("Token Type", resToken) + getHTMLRow("Issued at", resIssued) + getHTMLRow("Expires in", resExpires) + getHTMLRow("Access Token", accessTokenString) + "</table>"
    return formatted
  }
  
  def getHTMLRow(key: String, value: String) : String = {
    return "<tr><td width=\"30%\">" + key + "</td><td width=\"70%\">" + value + "</td></tr>"
  }
  
}