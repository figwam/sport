package controllers

import java.util.UUID
import java.util.concurrent.TimeoutException
import javax.inject.{Singleton, Inject}

import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import models._
import models.daos.{TraineeDAO, ClazzDAO}
import org.postgresql.util.PSQLException
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
  clazzDAO: ClazzDAO,
  traineeDAO: TraineeDAO)
  extends Silhouette[Trainee, JWTAuthenticator] {

  /**
   * Returns the trainee.
   *
   * @return The result to display.
   */
  def trainee = SecuredAction.async { implicit request =>
    Future.successful(Ok(Json.toJson(request.identity)))
  }

  def book(idClazz: Long) = SecuredAction.async(parse.json) { implicit request =>
    (request.body \ "idTrainee").asOpt[Long].map { idTrainee =>
      traineeDAO.book(Registration(None, UUID.randomUUID(), idTrainee, idClazz))
        .onFailure{case t => Logger.warn(t.getMessage)}
      Future.successful(Ok)
    }.getOrElse {
      Future.successful(BadRequest("Missing parameter [idTrainee]"))
  }
    /*
    try {
      (request.body \ "idTrainee").asOpt[Long].map { idTrainee =>
        val future = traineeDAO.book(Registration(None, UUID.randomUUID(), idTrainee, idClazz))
        future.onSuccess { case a => Logger.debug(s"Registration created: $a"); Future.successful(Ok)}
        future.onFailure {
          case t: PSQLException => {
            if (t.getMessage.contains("duplicate key value violates unique constraint")) {
              Logger.info("Registration already exists")
              Future.successful(BadRequest("registration already exists"))
            }
            else {
              Logger.error("Something bad happened", t)
              Future.successful(InternalServerError("Something bad happened"))
            }
          }
          case t: Throwable => {
            Logger.error(t.getMessage,t)
            Future.successful(InternalServerError("Something bad happened"))
          }
          case _ => Future.successful(BadRequest("Missing parameter [idTrainee]"))
        }
      }.getOrElse {
        Future.successful(BadRequest("Missing parameter [idTrainee]"))
      }
    } catch {
      case t: Throwable =>
        Logger.error(t.getMessage,t)
        Future.successful(InternalServerError("Something bad happened"))
    }
    */
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
    template match {
      case "dashboard" => Future.successful(Ok(views.html.me.dashboard()))
      case "header" => Future.successful(Ok(views.html.me.header()))
      case "sidebar" => Future.successful(Ok(views.html.me.sidebar()))
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
      case _ => NotFound
    }
  }
}
