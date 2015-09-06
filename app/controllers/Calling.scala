package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import java.net.{URI, URLDecoder, URLEncoder}
import models.User
import views._
import scala.util.Random

import java.io.FileWriter

/**
 * @author tzhpffe3
 */
object Calling extends Controller {
  
  def index(backend : String) = Action { implicit request => 
    val client_id = Play.current.configuration.getString(backend + ".call.client_id").get
    val redirect_uri = Play.current.configuration.getString(backend + ".call.redirect_uri").get
    /*
   val f = new FileWriter("c:/temp/demoapi_log_1.log")
    f.write("Hallo file")
    f.close()
    */
    
    Ok(html.consent.call.index(backend,redirect_uri,client_id,None))
    
  }
  
  def consetCallback() = Action { implicit request =>
    
    val client_id = Play.current.configuration.getString("local.call.client_id").get
    val redirect_uri = Play.current.configuration.getString("local.call.redirect_uri").get
    /*
    val f = new FileWriter("c:/temp/demoapi_log.log")
    f.write("request: "+request+"\n")
    f.write("request: "+request.toString())
    f.write("\nheaders: "+request.headers+"\n")
    f.write("queryString: "+request.queryString.toString())
    f.write("\nuri: "+request.uri)
    f.write("\nbody: "+request.body)
    f.write("\nrawQueryString: "+request.rawQueryString)
    
    f.close()
    */
    
    // Ok(html.consent.call.index("local",client_id,redirect_uri,None))
    Ok("Hello world! [" + request +"]")
  }
}