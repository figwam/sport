package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt
import play.api.libs.ws.Response
import play.api.libs.ws.WS
import play.api.Play.current
import javax.inject.Inject

import scala.concurrent.Future
import play.api.mvc._
import play.api.libs.ws._
import play.api.libs.iteratee._
import scala.concurrent.ExecutionContext.Implicits.global

object Callouts extends Controller {



  def getStaticGoogleMap = Action.async {

    // Make the request
    val request = WS.url("http://maps.googleapis.com/maps/api/staticmap")
    val promise =
      request.withRequestTimeout(10000)
        .withQueryString("center" -> "Bern")
        .withQueryString("zoom" -> "13")
        .withQueryString("size" -> "600x300")
        .withQueryString("maptype" -> "roadmap")
        .withQueryString("sensor" -> "false")
        .withQueryString("marker" -> "color:red%7Clabel:G%7C46.9485384,7.4473883")
        .withQueryString("marker" -> "color:red%7Clabel:S%7C46.9481282,7.4465944")
        .withQueryString("marker" -> "color:red%7Clabel:C%7C46.931828,7.419808")
        .getStream().map {
          case (response, body) =>

            // Check that the response was successful
            if (response.status == 200) {

              // Get the content type
              val contentType = response.headers.get("Content-Type").flatMap(_.headOption)
                .getOrElse("application/octet-stream")

              // If there's a content length, send that, otherwise return the body chunked
              response.headers.get("Content-Length") match {
                case Some(Seq(length)) =>
                  Ok.feed(body).as(contentType).withHeaders("Content-Length" -> length)
                case _ =>
                  Ok.chunked(body).as(contentType)
              }
            } else {
              BadGateway
            }
        }
  }
}