package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.User

import views._

object SSOMock extends Controller {
    
  val userForm: Form[User] = Form(
    // Define a mapping that will handle User values
//    mapping(
//      "pno" -> text(minLength = 10)
//    )(User.apply)(User.unapply)
//    )
    
    mapping(
      "username" -> text,
      "name" -> text,
      "password" -> text)
      ((username, name, password) => User(username, name, password, "demapi"))
      ((user: User) => Some(user.username, user.name, user.password))
  )
  
  val loginForm = Form(
    tuple(
      "username" -> text,
      "password" -> text
    ) verifying ("Invalid username or password", result => result match {
      case (username, password) => User.authenticate(username, password).isDefined
    })
  )


  def index = Action { implicit request =>
    Ok(views.html.mock.sso.SwisscomLogin(loginForm))
  }

  def indexTopLeft = Action { implicit request =>
    Ok(views.html.mock.sso.iframeleft())
  }

  def indexLeft = Action { implicit request =>
    Ok(views.html.mock.sso.iframetopleft())
  }

}