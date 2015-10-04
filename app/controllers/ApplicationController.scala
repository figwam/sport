package controllers

import java.util.concurrent.TimeoutException
import javax.inject.{Singleton, Inject}

import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import models.{Trainee}
import models.daos.{ClazzDAO}
import play.api.Logger
import play.api.i18n.MessagesApi
import play.api.libs.json.Json
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future

/**
 * The basic application controller.
 *
 * @param messagesApi The Play messages API.
 * @param env The Silhouette environment.
 * @param socialProviderRegistry The social provider registry.
 */
@Singleton
class ApplicationController @Inject() (
  val messagesApi: MessagesApi,
  val env: Environment[Trainee, JWTAuthenticator],
  socialProviderRegistry: SocialProviderRegistry,
  clazzDAO: ClazzDAO)
  extends Silhouette[Trainee, JWTAuthenticator] {

  /**
   * Returns the trainee.
   *
   * @return The result to display.
   */
  def trainee = SecuredAction.async { implicit request =>
    Future.successful(Ok(Json.toJson(request.identity)))
  }


  def clazzes(page: Int, orderBy: Int, filter: String) = UserAwareAction.async { implicit request =>
    clazzDAO.list(page, 10, orderBy, "%" + filter + "%").flatMap { pageClazzes =>
      Future.successful(Ok(Json.toJson(pageClazzes)))
    }.recover {
      case ex: TimeoutException =>
        Logger.error("Problem found in clazz list process")
        InternalServerError(ex.getMessage)
    }
  }

  /**
   * Manages the sign out action.
   */
  def signOut = SecuredAction.async { implicit request =>
    env.eventBus.publish(LogoutEvent(request.identity, request, request2Messages))
    env.authenticatorService.discard(request.authenticator, Ok)
  }

  /**
   * Provides the desired template.
   *
   * @param template The template to provide.
   * @return The template.
   */

  def viewRestricted(template: String) = SecuredAction.async { implicit request =>
    print("ddssadjslkljdlsls")
    template match {
      case "dashboard" => Future.successful(Ok(views.html.dashboard()))
      case _ => Future.successful(NotFound)
    }
  }

  def view(template: String) = UserAwareAction { implicit request =>
    template match {
      case "home" => Ok(views.html.home())
      case "signUp" => Ok(views.html.signUp())
      case "signIn" => Ok(views.html.signIn(socialProviderRegistry))
      case "clazzes" => Ok(views.html.clazzes())
      case "header" => Ok(views.html.header())
      case "footer" => Ok(views.html.footer())
      case "dashboard" => Ok(views.html.dashboard())
      case _ => NotFound
    }
  }
}
