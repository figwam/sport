package controllers

import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import models.Sms
import play.api.Logger
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.nonEmptyText
import play.api.libs.ws.Response
import play.api.libs.ws.WS
import play.api.mvc.Action
import play.api.mvc.Controller
import views.html

object SmsSender extends Controller {

  val smsForm: Form[Sms] = Form(
    mapping(
      "senderMsisdn" -> nonEmptyText,
      "recipient" -> nonEmptyText,
      "message" -> nonEmptyText
    )(Sms.apply)(Sms.unapply)
  )
  
  def form = Action { implicit request =>
    Ok(html.messaging.sms.form(smsForm));
  }
  
  def send = Action { implicit request =>
    Logger.info("Do send")
    smsForm.bindFromRequest.fold(
      errors => BadRequest(html.messaging.sms.form(errors)),
      sms => {
      	var msg = "{"+
		   "\"outboundSMSMessageRequest\":{"+
		      "\"address\":["+
		         "\"tel:"+sms.recipient+"\""+
		      "],"+
		      "\"senderAddress\":\"huhu\","+
		      "\"outboundSMSTextMessage\":{"+
		         "\"message\":\""+sms.message+"\""+
		      "},"+
		      "\"clientCorrelator\":\"clientCorrelator\","+
		      "\"senderName\":\"senderName\""+
		   "}"+
      	"}";
      	Logger.info(msg)
      	
      	val promise = WS.url("https://api.swisscom.com/v1/messaging/sms/outbound/tel:+41791544781/requests")
      			.withHeaders("client_id" -> "AR5wm07RBp9Sn57AaVtWq55mG9OFWPcA")
      			.withHeaders("accept" -> "application/json; charset=utf-8")
      			.withHeaders("Content-Type" -> "application/json")
      			.post(msg)

        try {
          val response = awaitResult(promise)
          Logger.info("=================================")
          println(response.body)
          println("=================================")
          
      	
          Ok(html.messaging.sms.form(smsForm))
        } catch {
          case e: Exception => {
            Logger.error("error sending sms", e)
            Ok(html.messaging.sms.form(null)) // errors => BadRequest(html.sms(errors)): would be the right approuch, but it doesnt work with jqm
          }
        }
      }
    )
  }
  
  protected def awaitResult(future: Future[Response]) = {
    Await.result(future, secondsToWait)
  }

  val secondsToWait = {
    import scala.concurrent.duration._
    10.seconds
  }
  
}