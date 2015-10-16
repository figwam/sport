package models.daos

import java.sql.Timestamp
import java.util.UUID

import com.mohiva.play.silhouette.api.LoginInfo
import models._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import javax.inject.Inject
import play.api.db.slick.DatabaseConfigProvider
import scala.concurrent.Future


import utils.Utils.asCalendar

/**
 * Give access to the trainee object using Slick
 */
class TraineeDAOImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends TraineeDAO with DAOSlick {

  import driver.api._

  /**
   * Finds a trainee by its login info.
   *
   * @param loginInfo The login info of the trainee to find.
   * @return The found trainee or None if no trainee for the given login info could be found.
   */
  def find(loginInfo: LoginInfo) = {
    val query = for {
      dbLoginInfo <- loginInfoQuery(loginInfo)
      dbTraineeLoginInfo <- slickTraineeLoginInfos.filter(_.idLoginInfo === dbLoginInfo.id)
      dbTrainee <- slickTrainees.filter(_.id === dbTraineeLoginInfo.idTrainee)
      dbAddress <- slickAddresses.filter(_.id === dbTrainee.idAddress)
      dbSubscription <- slickSubscriptions.filter(_.idTrainee === dbTrainee.id)
      dbOffer <- slickOffers.filter(_.id === dbSubscription.idOffer)
    } yield (dbTrainee, dbLoginInfo, dbAddress, dbSubscription, dbOffer)
    db.run(query.result.headOption).map { resultOption =>
      resultOption.map {
        case (trainee, loginInfo, address, subscription, offer) =>
          Trainee(trainee.id,
            LoginInfo(loginInfo.providerId, loginInfo.providerKey),
            trainee.firstname,
            trainee.lastname,
            trainee.mobile,
            trainee.phone,
            trainee.email,
            trainee.emailVerified,
            trainee.createdOn,
            trainee.updatedOn,
            trainee.ptoken,
            trainee.isActive,
            trainee.inactiveReason,
            trainee.username,
            trainee.fullname,
            trainee.avatarurl,
            Address(
              address.id,
              address.street,
              address.city,
              address.zip,
              address.state,
              address.country),
          None,
            Some(Subscription(
              subscription.id,
              subscription.isActive,
              subscription.canceledOn match { case Some(c) => Some(asCalendar(c)) case _ => None},
              Offer(
                offer.id,
                offer.name,
                offer.nrAccess,
                offer.nrAccessSame,
                offer.price)
            ))
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
      None,
      true,
      trainee.inactiveReason,
      UUID.randomUUID(), // Will be set later
      trainee.username,
      trainee.fullname,
      trainee.avatarurl)

    val dbAddress = DBAddress(
      None,
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
        into((address, id) => address.copy(id = id)) += dbAddress
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
      _ <- slickTraineeLoginInfos += DBTraineeLoginInfo(new Timestamp(System.currentTimeMillis), dbTraineeP.head.get, loginInfo.id.get)
      _ <- slickSubscriptions += DBSubscription(None, new Timestamp(System.currentTimeMillis), new Timestamp(System.currentTimeMillis), true, None, trainee.selectedOfferId.get, dbTraineeP.head.get)
    } yield ()).transactionally
    // run actions and return trainee afterwards
    db.run(actions).map(_ => trainee)
  }
}
