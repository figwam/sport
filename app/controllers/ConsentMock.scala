package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.User
import views._
import models._

object ConsentMock extends Controller {
  
  def index = Action { implicit request =>
    Ok(views.html.mock.consent.SwisscomConsent())
  }

  def submit = Action { implicit request =>
    Redirect(routes.ConsentVerifyAddress.form+"?app=manual&code=m0Ck32")
  }
  
}