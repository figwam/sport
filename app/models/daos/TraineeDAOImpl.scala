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
 * Give access to the trainee object using Slick
 */
class TraineeDAOImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends TraineeDAO with DAOSlick {

  import driver.api._

  /**
   * Finds a trainee by its login info.
   *
   * @param loginInfo The login info of the trainee to find.
   * @return The found trainee or None if no trainee for the given login info could be found.
   */
  def find(loginInfo: LoginInfo)= {
    val traineeQuery = for {
      dbLoginInfo <- loginInfoQuery(loginInfo)
      dbTraineeLoginInfo <- slickTraineeLoginInfos.filter(_.idLoginInfo === dbLoginInfo.id)
      dbTrainee <- slickTrainees.filter(_.id === dbTraineeLoginInfo.idTrainee)
      dbAddress <- slickAddresses.filter(_.id === dbTrainee.idAddress)
    } yield (dbTrainee, dbAddress)

    db.run(traineeQuery.result.headOption).map { dbTraineeAddressOption =>
      dbTraineeAddressOption.map {
        case (trainee, address) =>
          Trainee(trainee.id,
            loginInfo,
            UUID.fromString(trainee.extId),
            trainee.firstname,
            trainee.lastname,
            trainee.mobile,
            trainee.phone,
            trainee.email,
            trainee.emailVerified,
            trainee.createdOn,
            trainee.updatedOn,
            trainee.ptoken,
            trainee.isDeleted,
            trainee.deleteReason,
            trainee.isActive,
            trainee.inactiveReason,
            trainee.username,
            trainee.profiles,
            trainee.roles,
            trainee.fullname,
            trainee.avatarurl,
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
   * Finds a trainee by its trainee ID.
   *
   * @param traineeID The ID of the trainee to find.
   * @return The found trainee or None if no trainee for the given ID could be found.
   */
  def find(traineeID: Long) = {
    val query = for {
      dbTrainee <- slickTrainees.filter(_.id === traineeID)
      dbTraineeLoginInfo <- slickTraineeLoginInfos.filter(_.idLoginInfo === dbTrainee.id)
      dbLoginInfo <- slickLoginInfos.filter(_.id === dbTraineeLoginInfo.idLoginInfo)
      dbAddress <- slickAddresses.filter(_.id === dbTrainee.idAddress)
    } yield (dbTrainee, dbLoginInfo, dbAddress)
    db.run(query.result.headOption).map { resultOption =>
      resultOption.map {
        case (trainee, loginInfo, address) =>
          Trainee(trainee.id,
            LoginInfo(loginInfo.providerId, loginInfo.providerKey),
            UUID.fromString(trainee.extId),
            trainee.firstname,
            trainee.lastname,
            trainee.mobile,
            trainee.phone,
            trainee.email,
            trainee.emailVerified,
            trainee.createdOn,
            trainee.updatedOn,
            trainee.ptoken,
            trainee.isDeleted,
            trainee.deleteReason,
            trainee.isActive,
            trainee.inactiveReason,
            trainee.username,
            trainee.profiles,
            trainee.roles,
            trainee.fullname,
            trainee.avatarurl,
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
   * Saves a trainee.
   *
   * @param trainee The trainee to save.
   * @return The saved trainee.
   */
  def save(trainee: Trainee) = {
    val dbTrainee = DBTrainee(
      trainee.id,
      UUID.randomUUID().toString,
      trainee.firstname,
      trainee.lastname,
      trainee.mobile,
      trainee.phone,
      trainee.email,
      false,
      new Timestamp(System.currentTimeMillis),
      new Timestamp(System.currentTimeMillis),
      trainee.ptoken,
      false,
      trainee.deleteReason,
      true,
      trainee.inactiveReason,
      -1L,
      trainee.username,
      "None",
      "None",
      trainee.fullname,
      trainee.avatarurl)

    val dbAddress = DBAddress(
      None,
      UUID.randomUUID().toString,
      trainee.address.street,
      trainee.address.zip,
      trainee.address.city,
      trainee.address.state,
      trainee.address.country,
      new Timestamp(System.currentTimeMillis),
      new Timestamp(System.currentTimeMillis), false, None, None)

    val dbLoginInfo = DBLoginInfo(None,
      trainee.loginInfo.providerID,
      trainee.loginInfo.providerKey,
      new Timestamp(System.currentTimeMillis),
      new Timestamp(System.currentTimeMillis),
      None,
      new Timestamp(System.currentTimeMillis))

    // We don't have the address id so we try to get it first.
    // If there is no Address yet for this trainee we retrieve the id on insertion.
    val addressAction = {
      val retrieveAddress = slickAddresses.filter(
        address => address.id === trainee.address.id).result.headOption
      val insertAddress = slickAddresses.returning(slickAddresses.map(_.id)).
        into((address, id) => address.copy(id = Some(id))) += dbAddress
      for {
        addressOption <- retrieveAddress
        address <- addressOption.map(DBIO.successful(_)).getOrElse(insertAddress)
      } yield address
    }

    // We don't have the LoginInfo id so we try to get it first.
    // If there is no LoginInfo yet for this trainee we retrieve the id on insertion.
    val loginInfoAction = {
      val retrieveLoginInfo = slickLoginInfos.filter(
        info => info.providerId === trainee.loginInfo.providerID && info.providerKey === trainee.loginInfo.providerKey).result.headOption
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
      dbTraineeP <- slickTrainees.returning(slickTrainees.map(_.id)).insertOrUpdate(dbTrainee.copy(idAddress = address.id.get))
      loginInfo <- loginInfoAction
      _ <- slickTraineeLoginInfos += DBTraineeLoginInfo(new Timestamp(System.currentTimeMillis), dbTraineeP.head.get , loginInfo.id.get)
    } yield ()).transactionally
    // run actions and return trainee afterwards
    db.run(actions).map(_ => trainee)
  }
}
