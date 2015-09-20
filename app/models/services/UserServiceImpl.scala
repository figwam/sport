package models.services

import java.sql.Timestamp
import java.util.UUID
import javax.inject.Inject

import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.impl.providers.CommonSocialProfile
import models.User
import models.daos.UserDAO
import play.api.libs.concurrent.Execution.Implicits._

import scala.concurrent.Future

/**
 * Handles actions to users.
 *
 * @param userDAO The user DAO implementation.
 */
class UserServiceImpl @Inject() (userDAO: UserDAO) extends UserService {

  /**
   * Retrieves a user that matches the specified login info.
   *
   * @param loginInfo The login info to retrieve a user.
   * @return The retrieved user or None if no user could be retrieved for the given login info.
   */
  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = userDAO.find(loginInfo)

  /**
   * Saves a user.
   *
   * @param user The user to save.
   * @return The saved user.
   */
  def save(user: User) = userDAO.save(user)

  /**
   * Saves the social profile for a user.
   *
   * If a user exists for this profile then update the user, otherwise create a new user with the given profile.
   *
   * @param profile The social profile to save.
   * @return The user for whom the profile was saved.
   */

  def save(profile: CommonSocialProfile) = {
    userDAO.find(profile.loginInfo).flatMap {
      case Some(user) => // Update user with profile
        userDAO.save(user.copy(
          firstname = profile.firstName,
          lastname = profile.lastName,
          fullname = profile.fullName,
          email = profile.email,
          avatarurl = profile.avatarURL
        ))
      case None => // Insert a new user
        userDAO.save(User(
          id = None,
          loginInfo = profile.loginInfo,
          extId = UUID.randomUUID(),
          firstname = profile.firstName,
          lastname = profile.lastName,
          mobile = None,
          phone = None,
          email = profile.email,
          emailVerified = false,
          createdOn = new Timestamp(System.currentTimeMillis()),
          updatedOn = new Timestamp(System.currentTimeMillis()),
          ptoken = None,
          isDeleted = false,
          deleteReason = None,
          isActive = true,
          inactiveReason = None,
          username = profile.email,
          profiles = "None",
          roles = "None",
          fullname = profile.fullName,
          avatarurl = profile.avatarURL,
          null
        ))
    }
  }

}
