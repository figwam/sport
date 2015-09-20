package models.daos

import java.sql.Timestamp
import java.util.UUID

import com.mohiva.play.silhouette.api.LoginInfo
import models._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.dbio.DBIOAction
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future

/**
 * Give access to the user object using Slick
 */
class UserDAOImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends UserDAO with DAOSlick {

  import driver.api._

  /**
   * Finds a user by its login info.
   *
   * @param loginInfo The login info of the user to find.
   * @return The found user or None if no user for the given login info could be found.
   */
  def find(loginInfo: LoginInfo)= {
    val userQuery = for {
      dbLoginInfo <- loginInfoQuery(loginInfo)
      dbUserLoginInfo <- slickUserLoginInfos.filter(_.idLoginInfo === dbLoginInfo.id)
      dbUser <- slickUsers.filter(_.id === dbUserLoginInfo.idUser)
      dbAddress <- slickAddresses.filter(_.id === dbUser.idAddress)
    } yield (dbUser, dbAddress)

    db.run(userQuery.result.headOption).map { dbUserAddressOption =>
      dbUserAddressOption.map {
        case (user, address) =>
          User(user.id,
            loginInfo,
            UUID.fromString(user.extId),
            user.firstname,
            user.lastname,
            user.mobile,
            user.phone,
            user.email,
            user.emailVerified,
            user.createdOn,
            user.updatedOn,
            user.ptoken,
            user.isDeleted,
            user.deleteReason,
            user.isActive,
            user.inactiveReason,
            user.username,
            user.profiles,
            user.roles,
            user.fullname,
            user.avatarurl,
            Address(
              address.id,
              UUID.fromString(address.extId),
              address.street,
              address.city,
              address.zip,
              address.state,
              address.country)
          )
      }
    }
  }

  /**
   * Finds a user by its user ID.
   *
   * @param userID The ID of the user to find.
   * @return The found user or None if no user for the given ID could be found.
   */
  def find(userID: Long) = {
    val query = for {
      dbUser <- slickUsers.filter(_.id === userID)
      dbUserLoginInfo <- slickUserLoginInfos.filter(_.idLoginInfo === dbUser.id)
      dbLoginInfo <- slickLoginInfos.filter(_.id === dbUserLoginInfo.idLoginInfo)
      dbAddress <- slickAddresses.filter(_.id === dbUser.idAddress)
    } yield (dbUser, dbLoginInfo, dbAddress)
    db.run(query.result.headOption).map { resultOption =>
      resultOption.map {
        case (user, loginInfo, address) =>
          User(user.id,
            LoginInfo(loginInfo.providerId, loginInfo.providerKey),
            UUID.fromString(user.extId),
            user.firstname,
            user.lastname,
            user.mobile,
            user.phone,
            user.email,
            user.emailVerified,
            user.createdOn,
            user.updatedOn,
            user.ptoken,
            user.isDeleted,
            user.deleteReason,
            user.isActive,
            user.inactiveReason,
            user.username,
            user.profiles,
            user.roles,
            user.fullname,
            user.avatarurl,
            Address(
              address.id,
              UUID.fromString(address.extId),
              address.street,
              address.city,
              address.zip,
              address.state,
              address.country)
          )
      }
    }
  }

  /**
   * Saves a user.
   *
   * @param user The user to save.
   * @return The saved user.
   */
  def save(user: User) = {
    val dbUser = DBUser(
      user.id,
      UUID.randomUUID().toString,
      user.firstname,
      user.lastname,
      user.mobile,
      user.phone,
      user.email,
      false,
      new Timestamp(System.currentTimeMillis),
      new Timestamp(System.currentTimeMillis),
      user.ptoken,
      false,
      user.deleteReason,
      true,
      user.inactiveReason,
      -1L,
      user.username,
      "None",
      "None",
      user.fullname,
      user.avatarurl)

    val dbAddress = DBAddress(
      None,
      UUID.randomUUID().toString,
      user.address.street,
      user.address.zip,
      user.address.city,
      user.address.state,
      user.address.country,
      new Timestamp(System.currentTimeMillis),
      new Timestamp(System.currentTimeMillis), false, None, None)

    val dbLoginInfo = DBLoginInfo(None,
      user.loginInfo.providerID,
      user.loginInfo.providerKey,
      new Timestamp(System.currentTimeMillis),
      new Timestamp(System.currentTimeMillis),
      None,
      new Timestamp(System.currentTimeMillis))

    // We don't have the address id so we try to get it first.
    // If there is no Address yet for this user we retrieve the id on insertion.
    val addressAction = {
      val retrieveAddress = slickAddresses.filter(
        address => address.id === user.address.id).result.headOption
      val insertAddress = slickAddresses.returning(slickAddresses.map(_.id)).
        into((address, id) => address.copy(id = Some(id))) += dbAddress
      for {
        addressOption <- retrieveAddress
        address <- addressOption.map(DBIO.successful(_)).getOrElse(insertAddress)
      } yield address
    }

    // We don't have the LoginInfo id so we try to get it first.
    // If there is no LoginInfo yet for this user we retrieve the id on insertion.    
    val loginInfoAction = {
      val retrieveLoginInfo = slickLoginInfos.filter(
        info => info.providerId === user.loginInfo.providerID && info.providerKey === user.loginInfo.providerKey).result.headOption
      val insertLoginInfo = slickLoginInfos.returning(slickLoginInfos.map(_.id)).
        into((info, id) => info.copy(id = id)) += dbLoginInfo
      for {
        loginInfoOption <- retrieveLoginInfo
        loginInfo <- loginInfoOption.map(DBIO.successful(_)).getOrElse(insertLoginInfo)
      } yield loginInfo
    }
    // combine database actions to be run sequentially
    val actions = (for {
      address <- addressAction
      dbUserP <- slickUsers.returning(slickUsers.map(_.id)).insertOrUpdate(dbUser.copy(idAddress = address.id.get))
      loginInfo <- loginInfoAction
      _ <- slickUserLoginInfos += DBUserLoginInfo(new Timestamp(System.currentTimeMillis), dbUserP.head.get , loginInfo.id.get)
    } yield ()).transactionally
    // run actions and return user afterwards
    db.run(actions).map(_ => user)
  }
}
