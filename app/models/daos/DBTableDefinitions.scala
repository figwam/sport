package models.daos

import com.mohiva.play.silhouette.api.LoginInfo
import slick.driver.JdbcProfile
import slick.lifted.ProvenShape.proveShapeOf

trait DBTableDefinitions {

  protected val driver: JdbcProfile
  import driver.api._

case class DBAddress(
  id: Option[Long],
  extId: String,
  street: String,
  zip: String,
  city: String,
  state: String,
  country: String,
  createdOn: java.sql.Timestamp,
  updatedOn: java.sql.Timestamp,
  isDeleted: Boolean = false,
  longitude: Option[scala.math.BigDecimal] = None,
  latitude: Option[scala.math.BigDecimal] = None
  )

  class Addresses(_tableTag: Tag) extends Table[DBAddress](_tableTag, "address") {
    def * = (id.?, extId, street, zip, city, state, country, createdOn, updatedOn, isDeleted, longitude, latitude) <> (DBAddress.tupled, DBAddress.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val street: Rep[String] = column[String]("street")
    val zip: Rep[String] = column[String]("zip")
    val city: Rep[String] = column[String]("city")
    val state: Rep[String] = column[String]("state")
    val country: Rep[String] = column[String]("country")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    val longitude: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("longitude", O.Default(None))
    val latitude: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("latitude", O.Default(None))
    val index1 = index("address_extid_idx", extId)
  }

  case class DBBill(
    id: Option[Long],
    extId: String,
    amount: scala.math.BigDecimal,
    createdOn: java.sql.Timestamp,
    vat: Short,
    idTrainee: Long
    )


  class Bills(_tableTag: Tag) extends Table[DBBill](_tableTag, "bill") {
    def * = (id.?, extId, amount, createdOn, vat, idTrainee) <> (DBBill.tupled, DBBill.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val amount: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("amount")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val vat: Rep[Short] = column[Short]("vat")
    val idTrainee: Rep[Long] = column[Long]("id_trainee")
    lazy val traineeFk = foreignKey("trainee_fk", idTrainee, slickTrainees)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.SetNull)
    val index1 = index("ext_id_idx", extId)
  }

  case class DBClazz(
    id: Option[Long],
    extId: String,
    startFrom: java.sql.Timestamp,
    endAt: java.sql.Timestamp,
    name: String,
    recurring: Boolean = true,
    contingent: Short,
    createdOn: java.sql.Timestamp,
    updatedOn: java.sql.Timestamp,
    idStudio: Long
    )


  class Clazzes(_tableTag: Tag) extends Table[DBClazz](_tableTag, "clazz") {
    def * = (id.?, extId, startFrom, endAt, name, recurring, contingent, createdOn, updatedOn, idStudio) <> (DBClazz.tupled, DBClazz.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val startFrom: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("start_from")
    val endAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("end_at")
    val name: Rep[String] = column[String]("name")
    val recurring: Rep[Boolean] = column[Boolean]("recurring", O.Default(true))
    val contingent: Rep[Short] = column[Short]("contingent")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    val idStudio: Rep[Long] = column[Long]("id_studio")
    lazy val studioFk = foreignKey("studio_fk", idStudio, slickStudios)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("training_ext_id_idx", extId)
  }

  case class DBLoginInfo(
    id: Option[Long],
    providerId: String,
    providerKey: String,
    lastUsed: java.sql.Timestamp,
    expiration: java.sql.Timestamp,
    fingerprint: Option[String] = None,
    createdOn: java.sql.Timestamp)


  class LoginInfos(_tableTag: Tag) extends Table[DBLoginInfo](_tableTag, "login_info") {
    def * = (id, providerId, providerKey, lastUsed, expiration, fingerprint, createdOn) <> (DBLoginInfo.tupled, DBLoginInfo.unapply)
    val id: Rep[Option[Long]] = column[Option[Long]]("id", O.AutoInc, O.PrimaryKey)
    val providerId: Rep[String] = column[String]("provider_id")
    val providerKey: Rep[String] = column[String]("provider_key")
    val lastUsed: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_used")
    val expiration: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("expiration")
    val fingerprint: Rep[Option[String]] = column[Option[String]]("fingerprint", O.Default(None))
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val index1 = index("idx_login_info_provider_key", (providerId, providerKey))
  }


  case class DBOAuth1Info(
    id: Option[Long],
    token: String,
    secret: String,
    idLoginInfo: Long,
    created: java.sql.Timestamp)


  class OAuth1Infos(_tableTag: Tag) extends Table[DBOAuth1Info](_tableTag, "oauth1_info") {
    def * = (id.?, token, secret, idLoginInfo, created) <> (DBOAuth1Info.tupled, DBOAuth1Info.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val token: Rep[String] = column[String]("token")
    val secret: Rep[String] = column[String]("secret")
    val idLoginInfo: Rep[Long] = column[Long]("id_login_info")
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")
    lazy val loginInfoFk = foreignKey("login_info_fk", idLoginInfo, slickLoginInfos)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("oauth1_info_trainee_li_uq", idLoginInfo, unique=true)
  }

  case class DBOAuth2Info(
    id: Option[Long],
    idLoginInfo: Long,
    accessToken: String,
    tokenType: Option[String] = None,
    expiresIn: Option[Int] = None,
    refreshToken: Option[String] = None,
    created: java.sql.Timestamp
                           )


  class OAuth2Infos(_tableTag: Tag) extends Table[DBOAuth2Info](_tableTag, "oauth2_info") {
    def * = (id.?, idLoginInfo, accessToken, tokenType, expiresIn, refreshToken, created) <> (DBOAuth2Info.tupled, DBOAuth2Info.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val idLoginInfo: Rep[Long] = column[Long]("id_login_info")
    val accessToken: Rep[String] = column[String]("access_token")
    val tokenType: Rep[Option[String]] = column[Option[String]]("token_type", O.Default(None))
    val expiresIn: Rep[Option[Int]] = column[Option[Int]]("expires_in", O.Default(None))
    val refreshToken: Rep[Option[String]] = column[Option[String]]("refresh_token", O.Default(None))
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")
    lazy val loginInfoFk = foreignKey("login_info_fk", idLoginInfo, slickLoginInfos)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("oauth2_info_trainee_li_uq", idLoginInfo, unique=true)
  }

  case class DBOffer(
    id: Option[Long],
    extId: String,
    createdOn: java.sql.Timestamp,
    updatedOn: java.sql.Timestamp,
    name: String, nrAccess: Short,
    nrAccessSame: Short,
    price: scala.math.BigDecimal,
    isDeleted: Boolean = false
    )


  class Offers(_tableTag: Tag) extends Table[DBOffer](_tableTag, "offer") {
    def * = (id.?, extId, createdOn, updatedOn, name, nrAccess, nrAccessSame, price, isDeleted) <> (DBOffer.tupled, DBOffer.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    val name: Rep[String] = column[String]("name")
    val nrAccess: Rep[Short] = column[Short]("nr_access")
    val nrAccessSame: Rep[Short] = column[Short]("nr_access_same")
    val price: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("price")
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    val index1 = index("offer_ext_id_idx", extId)
  }

  case class DBOpenIDAttribute(id: String,
                               key: String,
                               value: String)


  class OpenIDAttributes(_tableTag: Tag) extends Table[DBOpenIDAttribute](_tableTag, "openidattributes") {
    def * = (id, key, value) <> (DBOpenIDAttribute.tupled, DBOpenIDAttribute.unapply)
    val id: Rep[String] = column[String]("id")
    val key: Rep[String] = column[String]("key")
    val value: Rep[String] = column[String]("value")
  }

  case class DBOpenIDInfo(
                                 id: String,
                                 idLoginInfo: Long
                                 )


  class OpenIDInfos(_tableTag: Tag) extends Table[DBOpenIDInfo](_tableTag, "openidinfo") {
    def * = (id, idLoginInfo) <> (DBOpenIDInfo.tupled, DBOpenIDInfo.unapply)
    val id: Rep[String] = column[String]("id", O.AutoInc, O.PrimaryKey)
    val idLoginInfo: Rep[Long] = column[Long]("id_login_info")
    lazy val loginInfoFk = foreignKey("login_info_fk", idLoginInfo, slickLoginInfos)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("password_info_trainee_li_uq", idLoginInfo, unique=true)
  }

  case class DBPasswordInfo(
    id: Option[Long],
    idLoginInfo: Long,
    hasher: String,
    password: String,
    salt: Option[String] = None,
    created: java.sql.Timestamp
    )


  class PasswordInfos(_tableTag: Tag) extends Table[DBPasswordInfo](_tableTag, "password_info") {
    def * = (id.?, idLoginInfo, hasher, password, salt, created) <> (DBPasswordInfo.tupled, DBPasswordInfo.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val idLoginInfo: Rep[Long] = column[Long]("id_login_info")
    val hasher: Rep[String] = column[String]("hasher")
    val password: Rep[String] = column[String]("password")
    val salt: Rep[Option[String]] = column[Option[String]]("salt", O.Default(None))
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")
    lazy val loginInfoFk = foreignKey("login_info_fk", idLoginInfo, slickLoginInfos)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("password_info_trainee_li_uq", idLoginInfo, unique=true)
  }

  case class DBRegistration(
    id: Option[Long],
    extId: String,
    createdOn: java.sql.Timestamp,
    idTrainee: Long,
    idClazz: Long
    )

  class Registrations(_tableTag: Tag) extends Table[DBRegistration](_tableTag, "registration") {
    def * = (id.?, extId, createdOn, idTrainee, idClazz) <> (DBRegistration.tupled, DBRegistration.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val idTrainee: Rep[Long] = column[Long]("id_trainee")
    val idClazz: Rep[Long] = column[Long]("id_clazz")
    lazy val clazzFk = foreignKey("clazz_fk", idClazz, slickClazzes)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    lazy val traineeFk = foreignKey("trainee_fk", idTrainee, slickTrainees)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("registration_ext_id_idx", extId)
    val index2 = index("registration_uq", idClazz, unique=true)
  }

  case class DBStudio(
    id: Option[Long],
    extId: String,
    name: String,
    mobile: Option[Short] = None,
    phone: Short,
    createdOn: java.sql.Timestamp,
    updatedOn: java.sql.Timestamp,
    isDeleted: Boolean = false,
    deletedReason: Option[String] = None,
    idAddress: Long,
    idPartner: Long
    )


  class Studios(_tableTag: Tag) extends Table[DBStudio](_tableTag, "studio") {
    def * = (id, extId, name, mobile, phone, createdOn, updatedOn, isDeleted, deletedReason, idAddress, idPartner) <> (DBStudio.tupled, DBStudio.unapply)
    val id: Rep[Option[Long]] = column[Option[Long]]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val name: Rep[String] = column[String]("name")
    val mobile: Rep[Option[Short]] = column[Option[Short]]("mobile", O.Default(None))
    val phone: Rep[Short] = column[Short]("phone")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    val deletedReason: Rep[Option[String]] = column[Option[String]]("deleted_reason", O.Default(None))
    val idAddress: Rep[Long] = column[Long]("id_address")
    val idPartner: Rep[Long] = column[Long]("id_partner")
    lazy val addressFk = foreignKey("address_fk", idAddress, slickAddresses)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    lazy val partnerFk = foreignKey("partner_fk", idPartner, slickTrainees)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.SetNull)
    val index1 = index("studio_extid_idx", extId)
    val index2 = index("studio_uq", idAddress, unique=true)
  }

  case class DBSubscription(
    id: Option[Long],
    extId: String,
    createdOn: java.sql.Timestamp,
    updatedOn: java.sql.Timestamp,
    isActive: Boolean = true,
    canceledOn: Option[java.sql.Timestamp] = None,
    idOffer: Long,
    idTrainee: Long
    )


  class Subscriptions(_tableTag: Tag) extends Table[DBSubscription](_tableTag, "subscription") {
    def * = (id.?, extId, createdOn, updatedOn, isActive, canceledOn, idOffer, idTrainee) <> (DBSubscription.tupled, DBSubscription.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    val isActive: Rep[Boolean] = column[Boolean]("is_active", O.Default(true))
    val canceledOn: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("canceled_on", O.Default(None))
    val idOffer: Rep[Long] = column[Long]("id_offer")
    val idTrainee: Rep[Long] = column[Long]("id_trainee")
    lazy val offerFk = foreignKey("offer_fk", idOffer, slickOffers)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    lazy val traineeFk = foreignKey("trainee_fk", idTrainee, slickTrainees)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("subscription_ext_id_idx", extId)
    val index2 = index("subscription_uq", idTrainee, unique=true)
    val index3 = index("subscription_uq1", idOffer, unique=true)
  }

  case class DBTimeStop(
    id: Option[Long],
    extId: String,
    stopOn: java.sql.Date,
    reason: String,
    createdOn: java.sql.Date,
    idSubscription: Long
    )


  class TimeStops(_tableTag: Tag) extends Table[DBTimeStop](_tableTag, "time_stop") {
    def * = (id.?, extId, stopOn, reason, createdOn, idSubscription) <> (DBTimeStop.tupled, DBTimeStop.unapply)
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val stopOn: Rep[java.sql.Date] = column[java.sql.Date]("stop_on")
    val reason: Rep[String] = column[String]("reason")
    val createdOn: Rep[java.sql.Date] = column[java.sql.Date]("created_on")
    val idSubscription: Rep[Long] = column[Long]("id_subscription")
    lazy val subscriptionFk = foreignKey("subscription_fk", idSubscription, slickSubscriptions)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("timestop_ext_id_idx", extId)
  }

  case class DBTrainee(
    id: Option[Long],
    extId: String,
    firstname: Option[String],
    lastname: Option[String],
    mobile: Option[String] = None,
    phone: Option[String] = None,
    email: Option[String] = None,
    emailVerified: Boolean = false,
    createdOn: java.sql.Timestamp,
    updatedOn: java.sql.Timestamp,
    ptoken: Option[String] = None,
    isDeleted: Boolean = false,
    deleteReason: Option[String] = None,
    isActive: Boolean = true,
    inactiveReason: Option[String] = None,
    idAddress: Long,
    username: Option[String] = None,
    profiles: String,
    roles: String,
    fullname: Option[String] = None,
    avatarurl: Option[String] = None
    )


  class Trainees(_tableTag: Tag) extends Table[DBTrainee](_tableTag, "trainee") {
    def * = (id, extId, firstname, lastname, mobile, phone, email, emailVerified, createdOn, updatedOn, ptoken, isDeleted, deleteReason, isActive, inactiveReason, idAddress, username, profiles, roles, fullname, avatarurl) <> (DBTrainee.tupled, DBTrainee.unapply)
    val id: Rep[Option[Long]] = column[Option[Long]]("id", O.AutoInc, O.PrimaryKey)
    val extId: Rep[String] = column[String]("ext_id")
    val firstname: Rep[Option[String]] = column[Option[String]]("firstname")
    val lastname: Rep[Option[String]] = column[Option[String]]("lastname")
    val mobile: Rep[Option[String]] = column[Option[String]]("mobile", O.Default(None))
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Default(None))
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Default(None))
    val emailVerified: Rep[Boolean] = column[Boolean]("email_verified", O.Default(false))
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    val ptoken: Rep[Option[String]] = column[Option[String]]("ptoken", O.Default(None))
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    val deleteReason: Rep[Option[String]] = column[Option[String]]("delete_reason", O.Default(None))
    val isActive: Rep[Boolean] = column[Boolean]("is_active", O.Default(true))
    val inactiveReason: Rep[Option[String]] = column[Option[String]]("inactive_reason", O.Default(None))
    val idAddress: Rep[Long] = column[Long]("id_address")
    val username: Rep[Option[String]] = column[Option[String]]("username", O.Default(None))
    val profiles: Rep[String] = column[String]("profiles")
    val roles: Rep[String] = column[String]("roles")
    val fullname: Rep[Option[String]] = column[Option[String]]("fullname", O.Default(None))
    val avatarurl: Rep[Option[String]] = column[Option[String]]("avatarurl", O.Default(None))
    lazy val addressFk = foreignKey("address_fk", idAddress, slickAddresses)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("trainee_extid_idx", extId)
    val index2 = index("trainee_uq", idAddress, unique=true)
    val index3 = index("trainee_roles_idx", roles)
    val index4 = index("trainee_username_idx", username)
  }

  case class DBTraineeLoginInfo(
    createdOn: java.sql.Timestamp,
    idTrainee: Long,
    idLoginInfo: Long
    )

  class TraineeLoginInfos(_tableTag: Tag) extends Table[DBTraineeLoginInfo](_tableTag, "trainee_login_info") {
    def * = (createdOn, idTrainee, idLoginInfo) <> (DBTraineeLoginInfo.tupled, DBTraineeLoginInfo.unapply)
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    val idTrainee: Rep[Long] = column[Long]("id_trainee")
    val idLoginInfo: Rep[Long] = column[Long]("id_login_info")
    lazy val loginInfoFk = foreignKey("login_info_fk", idLoginInfo, slickLoginInfos)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    lazy val traineeFk = foreignKey("trainee_fk", idTrainee, slickTrainees)(r => r.id.get, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    val index1 = index("trainee_login_info_trainee_li_uq", idLoginInfo, unique=true)
    val index2 = index("trainee_login_info_trainee_uq", idTrainee, unique=true)
  }

  // table query definitions
  val slickTrainees = TableQuery[Trainees]
  val slickLoginInfos = TableQuery[LoginInfos]
  val slickTraineeLoginInfos = TableQuery[TraineeLoginInfos]
  val slickPasswordInfos = TableQuery[PasswordInfos]
  val slickOAuth1Infos = TableQuery[OAuth1Infos]
  val slickOAuth2Infos = TableQuery[OAuth2Infos]
  val slickOpenIDInfos = TableQuery[OpenIDInfos]
  val slickOpenIDAttributes = TableQuery[OpenIDAttributes]
  val slickClazzes = TableQuery[Clazzes]
  val slickOffers = TableQuery[Offers]
  val slickRegistrations = TableQuery[Registrations]
  val slickStudios = TableQuery[Studios]
  val slickSubscriptions = TableQuery[Subscriptions]
  val slickTimeStops = TableQuery[TimeStops]
  val slickAddresses = TableQuery[Addresses]
  val slickBills = TableQuery[Bills]

  // queries used in multiple places
  def loginInfoQuery(loginInfo: LoginInfo) =
    slickLoginInfos.filter(dbLoginInfo => dbLoginInfo.providerId === loginInfo.providerID && dbLoginInfo.providerKey === loginInfo.providerKey)
}
