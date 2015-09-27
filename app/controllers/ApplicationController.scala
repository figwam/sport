package controllers

import javax.inject.{Singleton, Inject}

import akka.actor.Props
import com.mohiva.play.silhouette.api.{ Environment, LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.authenticators.JWTAuthenticator
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import models.Trainee
import models.daos.{TraineeDAO, ClazzDAO}
import play.api.i18n.MessagesApi
import play.api.libs.json.Json
import play.libs.Akka
import scheduler.ClazzScheduler

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
  socialProviderRegistry: SocialProviderRegistry
  //,clazzDAO: ClazzDAO
                                        )
  extends Silhouette[Trainee, JWTAuthenticator] {

  /**
   * Returns the trainee.
   *
   * @return The result to display.
   */
  def trainee = SecuredAction.async { implicit request =>
    //Akka.system.actorOf(Props(new ClazzScheduler(clazzDAO)), name = "clazzScheduler")
    Future.successful(Ok(Json.toJson(request.identity)))
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
  def view(template: String) = UserAwareAction { implicit request =>
    template match {
      case "home" => Ok(views.html.home())
      case "signUp" => Ok(views.html.signUp())
      case "signIn" => Ok(views.html.signIn(socialProviderRegistry))
      case "navigation" => Ok(views.html.navigation())
      case _ => NotFound
    }
  }
}
