package controllers

import java.sql.Timestamp
import java.util.UUID
import javax.inject.Inject

import com.mohiva.play.silhouette.api._
import com.mohiva.play.silhouette.api.repositories.AuthInfoRepository
import com.mohiva.play.silhouette.api.services.AvatarService
import com.mohiva.play.silhouette.api.util.PasswordHasher
import com.mohiva.play.silhouette.impl.authenticators.CookieAuthenticator
import com.mohiva.play.silhouette.impl.providers._
import forms.SignUpForm
import models.{Address, User}
import models.services.UserService
import play.api.i18n.{ MessagesApi, Messages }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc.Action

import scala.concurrent.Future

/**
 * The sign up controller.
 *
 * @param messagesApi The Play messages API.
 * @param env The Silhouette environment.
 * @param userService The user service implementation.
 * @param authInfoRepository The auth info repository implementation.
 * @param avatarService The avatar service implementation.
 * @param passwordHasher The password hasher implementation.
 */
class SignUpController @Inject() (
  val messagesApi: MessagesApi,
  val env: Environment[User, CookieAuthenticator],
  userService: UserService,
  authInfoRepository: AuthInfoRepository,
  avatarService: AvatarService,
  passwordHasher: PasswordHasher)
  extends Silhouette[User, CookieAuthenticator] {

  /**
   * Registers a new 
   *
   * @return The result to display.
   */
  def signUp = Action.async { implicit request =>
    SignUpForm.form.bindFromRequest.fold(
      form => Future.successful(BadRequest(views.html.signUp(form))),
      data => {
        val loginInfo = LoginInfo(CredentialsProvider.ID, data.email)
        userService.retrieve(loginInfo).flatMap {
          case Some(user) =>
            Future.successful(Redirect(routes.ApplicationController.signUp()).flashing("error" -> Messages("exists")))
          case None =>
            val authInfo = passwordHasher.hash(data.password)
            val addr = Address(
            None,
              UUID.randomUUID(),
              data.street,
              data.city,
              data.zip,
              data.state,
              "Switzerland"
            )
            val user = User(
              None,
              loginInfo = loginInfo,
              extId = UUID.randomUUID(),
              firstname = Some(data.firstName),
              lastname = Some(data.lastName),
              mobile = None,
              phone = None,
              email = Some(data.email),
              emailVerified = false,
              createdOn = new Timestamp(System.currentTimeMillis()),
              updatedOn = new Timestamp(System.currentTimeMillis()),
              ptoken = None,
              isDeleted = false,
              deleteReason = None,
              isActive = true,
              inactiveReason = None,
              username = Some (data.email),
              profiles = "None",
              roles = "None",
              fullname = Some(data.firstName + " " + data.lastName),
              avatarurl = None,
              address = addr
            )
            for {
              avatar <- avatarService.retrieveURL(data.email)
              user <- userService.save(user.copy(avatarurl = avatar))
              authInfo <- authInfoRepository.add(loginInfo, authInfo)
              authenticator <- env.authenticatorService.create(loginInfo)
              value <- env.authenticatorService.init(authenticator)
              result <- env.authenticatorService.embed(value, Redirect(routes.ApplicationController.index()))
            } yield {
              env.eventBus.publish(SignUpEvent(user, request, request2Messages))
              env.eventBus.publish(LoginEvent(user, request, request2Messages))
              result
            }
        }
      }
    )
  }
}
