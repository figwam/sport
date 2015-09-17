package models

/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.PostgresDriver
} with Tables

case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = Array(Address.schema, Offer.schema, Registration.schema, Studio.schema, Subscription.schema, TimeStop.schema, Training.schema, User.schema, Users.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Address
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param street Database column street SqlType(varchar)
   *  @param housenr Database column housenr SqlType(varchar)
   *  @param zip Database column zip SqlType(varchar)
   *  @param country Database column country SqlType(varchar)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param updatedOn Database column updated_on SqlType(timestamp)
   *  @param housename Database column houseName SqlType(varchar), Default(None)
   *  @param isDeleted Database column is_deleted SqlType(bool), Default(false)
   *  @param longitude Database column longitude SqlType(numeric), Default(None)
   *  @param latitude Database column latitude SqlType(numeric), Default(None) */
  case class AddressRow(id: Long, extId: String, street: String, housenr: String, zip: String, country: String, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, housename: Option[String] = None, isDeleted: Boolean = false, longitude: Option[scala.math.BigDecimal] = None, latitude: Option[scala.math.BigDecimal] = None)

  /** GetResult implicit for fetching AddressRow objects using plain SQL queries */
  implicit def GetResultAddressRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Option[String]], e4: GR[Boolean], e5: GR[Option[scala.math.BigDecimal]]): GR[AddressRow] = GR{
    prs => import prs._
    AddressRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[Boolean], <<?[scala.math.BigDecimal], <<?[scala.math.BigDecimal]))
  }

  /** Table description of table address. Objects of this class serve as prototypes for rows in queries. */
  class Address(_tableTag: Tag) extends Table[AddressRow](_tableTag, "address") {
    def * = (id, extId, street, housenr, zip, country, createdOn, updatedOn, housename, isDeleted, longitude, latitude) <> (AddressRow.tupled, AddressRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(street), Rep.Some(housenr), Rep.Some(zip), Rep.Some(country), Rep.Some(createdOn), Rep.Some(updatedOn), housename, Rep.Some(isDeleted), longitude, latitude).shaped.<>({r=>import r._; _1.map(_=> AddressRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10.get, _11, _12)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column street SqlType(varchar) */
    val street: Rep[String] = column[String]("street")
    /** Database column housenr SqlType(varchar) */
    val housenr: Rep[String] = column[String]("housenr")
    /** Database column zip SqlType(varchar) */
    val zip: Rep[String] = column[String]("zip")
    /** Database column country SqlType(varchar) */
    val country: Rep[String] = column[String]("country")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column houseName SqlType(varchar), Default(None) */
    val housename: Rep[Option[String]] = column[Option[String]]("houseName", O.Default(None))
    /** Database column is_deleted SqlType(bool), Default(false) */
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    /** Database column longitude SqlType(numeric), Default(None) */
    val longitude: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("longitude", O.Default(None))
    /** Database column latitude SqlType(numeric), Default(None) */
    val latitude: Rep[Option[scala.math.BigDecimal]] = column[Option[scala.math.BigDecimal]]("latitude", O.Default(None))

    /** Index over (extId) (database name address_extid_idx) */
    val index1 = index("address_extid_idx", extId)
  }
  /** Collection-like TableQuery object for table Address */
  lazy val Address = new TableQuery(tag => new Address(tag))

  /** Entity class storing rows of table Offer
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param updatedOn Database column updated_on SqlType(timestamp)
   *  @param name Database column name SqlType(varchar)
   *  @param nrAccess Database column nr_access SqlType(int2)
   *  @param nrAccessSame Database column nr_access_same SqlType(int2)
   *  @param price Database column price SqlType(numeric)
   *  @param isDeleted Database column is_deleted SqlType(bool), Default(false) */
  case class OfferRow(id: Long, extId: String, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, name: String, nrAccess: Short, nrAccessSame: Short, price: scala.math.BigDecimal, isDeleted: Boolean = false)
  /** GetResult implicit for fetching OfferRow objects using plain SQL queries */
  implicit def GetResultOfferRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Short], e4: GR[scala.math.BigDecimal], e5: GR[Boolean]): GR[OfferRow] = GR{
    prs => import prs._
    OfferRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[Short], <<[Short], <<[scala.math.BigDecimal], <<[Boolean]))
  }
  /** Table description of table offer. Objects of this class serve as prototypes for rows in queries. */
  class Offer(_tableTag: Tag) extends Table[OfferRow](_tableTag, "offer") {
    def * = (id, extId, createdOn, updatedOn, name, nrAccess, nrAccessSame, price, isDeleted) <> (OfferRow.tupled, OfferRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(name), Rep.Some(nrAccess), Rep.Some(nrAccessSame), Rep.Some(price), Rep.Some(isDeleted)).shaped.<>({r=>import r._; _1.map(_=> OfferRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column nr_access SqlType(int2) */
    val nrAccess: Rep[Short] = column[Short]("nr_access")
    /** Database column nr_access_same SqlType(int2) */
    val nrAccessSame: Rep[Short] = column[Short]("nr_access_same")
    /** Database column price SqlType(numeric) */
    val price: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("price")
    /** Database column is_deleted SqlType(bool), Default(false) */
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))

    /** Index over (extId) (database name offer_ext_id_idx) */
    val index1 = index("offer_ext_id_idx", extId)
  }
  /** Collection-like TableQuery object for table Offer */
  lazy val Offer = new TableQuery(tag => new Offer(tag))

  /** Entity class storing rows of table Registration
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param idUser Database column id_user SqlType(int8)
   *  @param idTraining Database column id_training SqlType(int4) */
  case class RegistrationRow(id: Int, extId: String, createdOn: java.sql.Timestamp, idUser: Long, idTraining: Int)
  /** GetResult implicit for fetching RegistrationRow objects using plain SQL queries */
  implicit def GetResultRegistrationRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Long]): GR[RegistrationRow] = GR{
    prs => import prs._
    RegistrationRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[Long], <<[Int]))
  }
  /** Table description of table registration. Objects of this class serve as prototypes for rows in queries. */
  class Registration(_tableTag: Tag) extends Table[RegistrationRow](_tableTag, "registration") {
    def * = (id, extId, createdOn, idUser, idTraining) <> (RegistrationRow.tupled, RegistrationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(createdOn), Rep.Some(idUser), Rep.Some(idTraining)).shaped.<>({r=>import r._; _1.map(_=> RegistrationRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column id_user SqlType(int8) */
    val idUser: Rep[Long] = column[Long]("id_user")
    /** Database column id_training SqlType(int4) */
    val idTraining: Rep[Int] = column[Int]("id_training")

    /** Foreign key referencing Training (database name training_fk) */
    lazy val trainingFk = foreignKey("training_fk", idTraining, Training)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing User (database name user_fk) */
    lazy val userFk = foreignKey("user_fk", idUser, User)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name registration_ext_id_idx) */
    val index1 = index("registration_ext_id_idx", extId)
    /** Uniqueness Index over (idTraining) (database name registration_uq) */
    val index2 = index("registration_uq", idTraining, unique=true)
  }
  /** Collection-like TableQuery object for table Registration */
  lazy val Registration = new TableQuery(tag => new Registration(tag))

  /** Entity class storing rows of table Studio
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param name Database column name SqlType(varchar)
   *  @param mobile Database column mobile SqlType(int2), Default(None)
   *  @param phone Database column phone SqlType(int2)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param updatedOn Database column updated_on SqlType(timestamp)
   *  @param isDeleted Database column is_deleted SqlType(bool), Default(false)
   *  @param deletedReason Database column deleted_reason SqlType(varchar), Default(None)
   *  @param idAddress Database column id_address SqlType(int8) */
  case class StudioRow(id: Long, extId: String, name: String, mobile: Option[Short] = None, phone: Short, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, isDeleted: Boolean = false, deletedReason: Option[String] = None, idAddress: Long)
  /** GetResult implicit for fetching StudioRow objects using plain SQL queries */
  implicit def GetResultStudioRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[Short]], e3: GR[Short], e4: GR[java.sql.Timestamp], e5: GR[Boolean], e6: GR[Option[String]]): GR[StudioRow] = GR{
    prs => import prs._
    StudioRow.tupled((<<[Long], <<[String], <<[String], <<?[Short], <<[Short], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Boolean], <<?[String], <<[Long]))
  }
  /** Table description of table studio. Objects of this class serve as prototypes for rows in queries. */
  class Studio(_tableTag: Tag) extends Table[StudioRow](_tableTag, "studio") {
    def * = (id, extId, name, mobile, phone, createdOn, updatedOn, isDeleted, deletedReason, idAddress) <> (StudioRow.tupled, StudioRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(name), mobile, Rep.Some(phone), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(isDeleted), deletedReason, Rep.Some(idAddress)).shaped.<>({r=>import r._; _1.map(_=> StudioRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7.get, _8.get, _9, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column mobile SqlType(int2), Default(None) */
    val mobile: Rep[Option[Short]] = column[Option[Short]]("mobile", O.Default(None))
    /** Database column phone SqlType(int2) */
    val phone: Rep[Short] = column[Short]("phone")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column is_deleted SqlType(bool), Default(false) */
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    /** Database column deleted_reason SqlType(varchar), Default(None) */
    val deletedReason: Rep[Option[String]] = column[Option[String]]("deleted_reason", O.Default(None))
    /** Database column id_address SqlType(int8) */
    val idAddress: Rep[Long] = column[Long]("id_address")

    /** Foreign key referencing Address (database name address_fk) */
    lazy val addressFk = foreignKey("address_fk", idAddress, Address)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name studio_extid_idx) */
    val index1 = index("studio_extid_idx", extId)
    /** Uniqueness Index over (idAddress) (database name studio_uq) */
    val index2 = index("studio_uq", idAddress, unique=true)
  }
  /** Collection-like TableQuery object for table Studio */
  lazy val Studio = new TableQuery(tag => new Studio(tag))

  /** Entity class storing rows of table Subscription
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param updatedOn Database column updated_on SqlType(timestamp)
   *  @param isInactive Database column is_inactive SqlType(bool), Default(false)
   *  @param idUser Database column id_user SqlType(int8)
   *  @param idOffer Database column id_offer SqlType(int8) */
  case class SubscriptionRow(id: Long, extId: String, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, isInactive: Boolean = false, idUser: Long, idOffer: Long)
  /** GetResult implicit for fetching SubscriptionRow objects using plain SQL queries */
  implicit def GetResultSubscriptionRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean]): GR[SubscriptionRow] = GR{
    prs => import prs._
    SubscriptionRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Boolean], <<[Long], <<[Long]))
  }
  /** Table description of table subscription. Objects of this class serve as prototypes for rows in queries. */
  class Subscription(_tableTag: Tag) extends Table[SubscriptionRow](_tableTag, "subscription") {
    def * = (id, extId, createdOn, updatedOn, isInactive, idUser, idOffer) <> (SubscriptionRow.tupled, SubscriptionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(isInactive), Rep.Some(idUser), Rep.Some(idOffer)).shaped.<>({r=>import r._; _1.map(_=> SubscriptionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column is_inactive SqlType(bool), Default(false) */
    val isInactive: Rep[Boolean] = column[Boolean]("is_inactive", O.Default(false))
    /** Database column id_user SqlType(int8) */
    val idUser: Rep[Long] = column[Long]("id_user")
    /** Database column id_offer SqlType(int8) */
    val idOffer: Rep[Long] = column[Long]("id_offer")

    /** Foreign key referencing Offer (database name offer_fk) */
    lazy val offerFk = foreignKey("offer_fk", idOffer, Offer)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing User (database name user_fk) */
    lazy val userFk = foreignKey("user_fk", idUser, User)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name subscription_ext_id_idx) */
    val index1 = index("subscription_ext_id_idx", extId)
    /** Uniqueness Index over (idUser) (database name subscription_uq) */
    val index2 = index("subscription_uq", idUser, unique=true)
    /** Uniqueness Index over (idOffer) (database name subscription_uq1) */
    val index3 = index("subscription_uq1", idOffer, unique=true)
  }
  /** Collection-like TableQuery object for table Subscription */
  lazy val Subscription = new TableQuery(tag => new Subscription(tag))

  /** Entity class storing rows of table TimeStop
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param stopOn Database column stop_on SqlType(date)
   *  @param reason Database column reason SqlType(varchar)
   *  @param createdOn Database column created_on SqlType(date)
   *  @param idSubscription Database column id_subscription SqlType(int8) */
  case class TimeStopRow(id: Long, extId: String, stopOn: java.sql.Date, reason: String, createdOn: java.sql.Date, idSubscription: Long)
  /** GetResult implicit for fetching TimeStopRow objects using plain SQL queries */
  implicit def GetResultTimeStopRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Date]): GR[TimeStopRow] = GR{
    prs => import prs._
    TimeStopRow.tupled((<<[Long], <<[String], <<[java.sql.Date], <<[String], <<[java.sql.Date], <<[Long]))
  }
  /** Table description of table time_stop. Objects of this class serve as prototypes for rows in queries. */
  class TimeStop(_tableTag: Tag) extends Table[TimeStopRow](_tableTag, "time_stop") {
    def * = (id, extId, stopOn, reason, createdOn, idSubscription) <> (TimeStopRow.tupled, TimeStopRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(stopOn), Rep.Some(reason), Rep.Some(createdOn), Rep.Some(idSubscription)).shaped.<>({r=>import r._; _1.map(_=> TimeStopRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column stop_on SqlType(date) */
    val stopOn: Rep[java.sql.Date] = column[java.sql.Date]("stop_on")
    /** Database column reason SqlType(varchar) */
    val reason: Rep[String] = column[String]("reason")
    /** Database column created_on SqlType(date) */
    val createdOn: Rep[java.sql.Date] = column[java.sql.Date]("created_on")
    /** Database column id_subscription SqlType(int8) */
    val idSubscription: Rep[Long] = column[Long]("id_subscription")

    /** Foreign key referencing Subscription (database name subscription_fk) */
    lazy val subscriptionFk = foreignKey("subscription_fk", idSubscription, Subscription)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name timestop_ext_id_idx) */
    val index1 = index("timestop_ext_id_idx", extId)
  }
  /** Collection-like TableQuery object for table TimeStop */
  lazy val TimeStop = new TableQuery(tag => new TimeStop(tag))

  /** Entity class storing rows of table Training
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param startFrom Database column start_from SqlType(timestamp)
   *  @param endAt Database column end_at SqlType(timestamp)
   *  @param name Database column name SqlType(varchar)
   *  @param recurring Database column recurring SqlType(bool), Default(true)
   *  @param contingent Database column contingent SqlType(int2)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param updatedOn Database column updated_on SqlType(timestamp)
   *  @param idStudio Database column id_studio SqlType(int8) */
  case class TrainingRow(id: Int, extId: String, startFrom: java.sql.Timestamp, endAt: java.sql.Timestamp, name: String, recurring: Boolean = true, contingent: Short, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, idStudio: Long)
  /** GetResult implicit for fetching TrainingRow objects using plain SQL queries */
  implicit def GetResultTrainingRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean], e4: GR[Short], e5: GR[Long]): GR[TrainingRow] = GR{
    prs => import prs._
    TrainingRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[Boolean], <<[Short], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Long]))
  }
  /** Table description of table training. Objects of this class serve as prototypes for rows in queries. */
  class Training(_tableTag: Tag) extends Table[TrainingRow](_tableTag, "training") {
    def * = (id, extId, startFrom, endAt, name, recurring, contingent, createdOn, updatedOn, idStudio) <> (TrainingRow.tupled, TrainingRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(startFrom), Rep.Some(endAt), Rep.Some(name), Rep.Some(recurring), Rep.Some(contingent), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(idStudio)).shaped.<>({r=>import r._; _1.map(_=> TrainingRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column start_from SqlType(timestamp) */
    val startFrom: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("start_from")
    /** Database column end_at SqlType(timestamp) */
    val endAt: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("end_at")
    /** Database column name SqlType(varchar) */
    val name: Rep[String] = column[String]("name")
    /** Database column recurring SqlType(bool), Default(true) */
    val recurring: Rep[Boolean] = column[Boolean]("recurring", O.Default(true))
    /** Database column contingent SqlType(int2) */
    val contingent: Rep[Short] = column[Short]("contingent")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column id_studio SqlType(int8) */
    val idStudio: Rep[Long] = column[Long]("id_studio")

    /** Foreign key referencing Studio (database name studio_fk) */
    lazy val studioFk = foreignKey("studio_fk", idStudio, Studio)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name training_ext_id_idx) */
    val index1 = index("training_ext_id_idx", extId)
  }
  /** Collection-like TableQuery object for table Training */
  lazy val Training = new TableQuery(tag => new Training(tag))

  /** Entity class storing rows of table User
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param firstname Database column firstname SqlType(varchar)
   *  @param lastname Database column lastname SqlType(varchar)
   *  @param mobile Database column mobile SqlType(varchar), Default(None)
   *  @param phone Database column phone SqlType(varchar), Default(None)
   *  @param email Database column email SqlType(varchar), Default(None)
   *  @param emailVerified Database column email_verified SqlType(bool), Default(false)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param updatedOn Database column updated_on SqlType(timestamp)
   *  @param ptoken Database column ptoken SqlType(varchar), Default(None)
   *  @param isDeleted Database column is_deleted SqlType(bool), Default(false)
   *  @param deleteReason Database column delete_reason SqlType(varchar), Default(None)
   *  @param isInactive Database column is_inactive SqlType(bool), Default(false)
   *  @param inactiveReason Database column inactive_reason SqlType(varchar), Default(None)
   *  @param idAddress Database column id_address SqlType(int8) */
  case class UserRow(id: Long, extId: String, firstname: String, lastname: String, mobile: Option[String] = None, phone: Option[String] = None, email: Option[String] = None, emailVerified: Boolean = false, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, ptoken: Option[String] = None, isDeleted: Boolean = false, deleteReason: Option[String] = None, isInactive: Boolean = false, inactiveReason: Option[String] = None, idAddress: Long)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[Boolean], e4: GR[java.sql.Timestamp]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[Boolean], <<?[String], <<[Boolean], <<?[String], <<[Long]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(_tableTag: Tag) extends Table[UserRow](_tableTag, "user") {
    def * = (id, extId, firstname, lastname, mobile, phone, email, emailVerified, createdOn, updatedOn, ptoken, isDeleted, deleteReason, isInactive, inactiveReason, idAddress) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(firstname), Rep.Some(lastname), mobile, phone, email, Rep.Some(emailVerified), Rep.Some(createdOn), Rep.Some(updatedOn), ptoken, Rep.Some(isDeleted), deleteReason, Rep.Some(isInactive), inactiveReason, Rep.Some(idAddress)).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8.get, _9.get, _10.get, _11, _12.get, _13, _14.get, _15, _16.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column firstname SqlType(varchar) */
    val firstname: Rep[String] = column[String]("firstname")
    /** Database column lastname SqlType(varchar) */
    val lastname: Rep[String] = column[String]("lastname")
    /** Database column mobile SqlType(varchar), Default(None) */
    val mobile: Rep[Option[String]] = column[Option[String]]("mobile", O.Default(None))
    /** Database column phone SqlType(varchar), Default(None) */
    val phone: Rep[Option[String]] = column[Option[String]]("phone", O.Default(None))
    /** Database column email SqlType(varchar), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Default(None))
    /** Database column email_verified SqlType(bool), Default(false) */
    val emailVerified: Rep[Boolean] = column[Boolean]("email_verified", O.Default(false))
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column ptoken SqlType(varchar), Default(None) */
    val ptoken: Rep[Option[String]] = column[Option[String]]("ptoken", O.Default(None))
    /** Database column is_deleted SqlType(bool), Default(false) */
    val isDeleted: Rep[Boolean] = column[Boolean]("is_deleted", O.Default(false))
    /** Database column delete_reason SqlType(varchar), Default(None) */
    val deleteReason: Rep[Option[String]] = column[Option[String]]("delete_reason", O.Default(None))
    /** Database column is_inactive SqlType(bool), Default(false) */
    val isInactive: Rep[Boolean] = column[Boolean]("is_inactive", O.Default(false))
    /** Database column inactive_reason SqlType(varchar), Default(None) */
    val inactiveReason: Rep[Option[String]] = column[Option[String]]("inactive_reason", O.Default(None))
    /** Database column id_address SqlType(int8) */
    val idAddress: Rep[Long] = column[Long]("id_address")

    /** Foreign key referencing Address (database name address_fk) */
    lazy val addressFk = foreignKey("address_fk", idAddress, Address)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name user_extid_idx) */
    val index1 = index("user_extid_idx", extId)
    /** Uniqueness Index over (idAddress) (database name user_uq) */
    val index2 = index("user_uq", idAddress, unique=true)
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))

  /** Entity class storing rows of table Users
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(varchar), Default(None)
   *  @param createdOn Database column created_on SqlType(timestamp) */
  case class UsersRow(id: Long, name: Option[String] = None, createdOn: java.sql.Timestamp)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Long], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Long], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends Table[UsersRow](_tableTag, "users") {
    def * = (id, name, createdOn) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, Rep.Some(createdOn)).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(varchar), Default(None) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Default(None))
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
