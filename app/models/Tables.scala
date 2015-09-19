package models
// AUTO-GENERATED Slick data model
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
  lazy val schema = Array(Address.schema, Clazz.schema, Oauth1Info.schema, Oauth2Info.schema, Offer.schema, OpenidInfo.schema, PasswordInfo.schema, Registration.schema, Requests.schema, SessionInfo.schema, Studio.schema, Subscription.schema, TimeStop.schema, UserProfiles.schema, Users.schema).reduceLeft(_ ++ _)
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

  /** Entity class storing rows of table Clazz
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
  case class ClazzRow(id: Int, extId: String, startFrom: java.sql.Timestamp, endAt: java.sql.Timestamp, name: String, recurring: Boolean = true, contingent: Short, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, idStudio: Long)
  /** GetResult implicit for fetching ClazzRow objects using plain SQL queries */
  implicit def GetResultClazzRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean], e4: GR[Short], e5: GR[Long]): GR[ClazzRow] = GR{
    prs => import prs._
    ClazzRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[String], <<[Boolean], <<[Short], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Long]))
  }
  /** Table description of table clazz. Objects of this class serve as prototypes for rows in queries. */
  class Clazz(_tableTag: Tag) extends Table[ClazzRow](_tableTag, "clazz") {
    def * = (id, extId, startFrom, endAt, name, recurring, contingent, createdOn, updatedOn, idStudio) <> (ClazzRow.tupled, ClazzRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(startFrom), Rep.Some(endAt), Rep.Some(name), Rep.Some(recurring), Rep.Some(contingent), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(idStudio)).shaped.<>({r=>import r._; _1.map(_=> ClazzRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
  /** Collection-like TableQuery object for table Clazz */
  lazy val Clazz = new TableQuery(tag => new Clazz(tag))

  /** Entity class storing rows of table Oauth1Info
   *  @param provider Database column provider SqlType(varchar), Length(64,true)
   *  @param key Database column key SqlType(text)
   *  @param token Database column token SqlType(text)
   *  @param secret Database column secret SqlType(text)
   *  @param created Database column created SqlType(timestamp) */
  case class Oauth1InfoRow(provider: String, key: String, token: String, secret: String, created: java.sql.Timestamp)
  /** GetResult implicit for fetching Oauth1InfoRow objects using plain SQL queries */
  implicit def GetResultOauth1InfoRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[Oauth1InfoRow] = GR{
    prs => import prs._
    Oauth1InfoRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table oauth1_info. Objects of this class serve as prototypes for rows in queries. */
  class Oauth1Info(_tableTag: Tag) extends Table[Oauth1InfoRow](_tableTag, "oauth1_info") {
    def * = (provider, key, token, secret, created) <> (Oauth1InfoRow.tupled, Oauth1InfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(provider), Rep.Some(key), Rep.Some(token), Rep.Some(secret), Rep.Some(created)).shaped.<>({r=>import r._; _1.map(_=> Oauth1InfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column provider SqlType(varchar), Length(64,true) */
    val provider: Rep[String] = column[String]("provider", O.Length(64,varying=true))
    /** Database column key SqlType(text) */
    val key: Rep[String] = column[String]("key")
    /** Database column token SqlType(text) */
    val token: Rep[String] = column[String]("token")
    /** Database column secret SqlType(text) */
    val secret: Rep[String] = column[String]("secret")
    /** Database column created SqlType(timestamp) */
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")

    /** Primary key of Oauth1Info (database name pk_oauth1_info) */
    val pk = primaryKey("pk_oauth1_info", (provider, key))
  }
  /** Collection-like TableQuery object for table Oauth1Info */
  lazy val Oauth1Info = new TableQuery(tag => new Oauth1Info(tag))

  /** Entity class storing rows of table Oauth2Info
   *  @param provider Database column provider SqlType(varchar), Length(64,true)
   *  @param key Database column key SqlType(text)
   *  @param accessToken Database column access_token SqlType(text)
   *  @param tokenType Database column token_type SqlType(varchar), Length(64,true), Default(None)
   *  @param expiresIn Database column expires_in SqlType(int4), Default(None)
   *  @param refreshToken Database column refresh_token SqlType(varchar), Length(64,true), Default(None)
   *  @param params Database column params SqlType(text), Default(None)
   *  @param created Database column created SqlType(timestamp), Default(None) */
  case class Oauth2InfoRow(provider: String, key: String, accessToken: String, tokenType: Option[String] = None, expiresIn: Option[Int] = None, refreshToken: Option[String] = None, params: Option[String] = None, created: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching Oauth2InfoRow objects using plain SQL queries */
  implicit def GetResultOauth2InfoRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Option[java.sql.Timestamp]]): GR[Oauth2InfoRow] = GR{
    prs => import prs._
    Oauth2InfoRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<?[Int], <<?[String], <<?[String], <<?[java.sql.Timestamp]))
  }
  /** Table description of table oauth2_info. Objects of this class serve as prototypes for rows in queries. */
  class Oauth2Info(_tableTag: Tag) extends Table[Oauth2InfoRow](_tableTag, "oauth2_info") {
    def * = (provider, key, accessToken, tokenType, expiresIn, refreshToken, params, created) <> (Oauth2InfoRow.tupled, Oauth2InfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(provider), Rep.Some(key), Rep.Some(accessToken), tokenType, expiresIn, refreshToken, params, created).shaped.<>({r=>import r._; _1.map(_=> Oauth2InfoRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column provider SqlType(varchar), Length(64,true) */
    val provider: Rep[String] = column[String]("provider", O.Length(64,varying=true))
    /** Database column key SqlType(text) */
    val key: Rep[String] = column[String]("key")
    /** Database column access_token SqlType(text) */
    val accessToken: Rep[String] = column[String]("access_token")
    /** Database column token_type SqlType(varchar), Length(64,true), Default(None) */
    val tokenType: Rep[Option[String]] = column[Option[String]]("token_type", O.Length(64,varying=true), O.Default(None))
    /** Database column expires_in SqlType(int4), Default(None) */
    val expiresIn: Rep[Option[Int]] = column[Option[Int]]("expires_in", O.Default(None))
    /** Database column refresh_token SqlType(varchar), Length(64,true), Default(None) */
    val refreshToken: Rep[Option[String]] = column[Option[String]]("refresh_token", O.Length(64,varying=true), O.Default(None))
    /** Database column params SqlType(text), Default(None) */
    val params: Rep[Option[String]] = column[Option[String]]("params", O.Default(None))
    /** Database column created SqlType(timestamp), Default(None) */
    val created: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created", O.Default(None))

    /** Primary key of Oauth2Info (database name pk_oauth2_info) */
    val pk = primaryKey("pk_oauth2_info", (provider, key))
  }
  /** Collection-like TableQuery object for table Oauth2Info */
  lazy val Oauth2Info = new TableQuery(tag => new Oauth2Info(tag))

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

  /** Entity class storing rows of table OpenidInfo
   *  @param provider Database column provider SqlType(varchar), Length(64,true)
   *  @param key Database column key SqlType(text)
   *  @param id Database column id SqlType(text)
   *  @param attributes Database column attributes SqlType(text)
   *  @param created Database column created SqlType(timestamp) */
  case class OpenidInfoRow(provider: String, key: String, id: String, attributes: String, created: java.sql.Timestamp)
  /** GetResult implicit for fetching OpenidInfoRow objects using plain SQL queries */
  implicit def GetResultOpenidInfoRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp]): GR[OpenidInfoRow] = GR{
    prs => import prs._
    OpenidInfoRow.tupled((<<[String], <<[String], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table openid_info. Objects of this class serve as prototypes for rows in queries. */
  class OpenidInfo(_tableTag: Tag) extends Table[OpenidInfoRow](_tableTag, "openid_info") {
    def * = (provider, key, id, attributes, created) <> (OpenidInfoRow.tupled, OpenidInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(provider), Rep.Some(key), Rep.Some(id), Rep.Some(attributes), Rep.Some(created)).shaped.<>({r=>import r._; _1.map(_=> OpenidInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column provider SqlType(varchar), Length(64,true) */
    val provider: Rep[String] = column[String]("provider", O.Length(64,varying=true))
    /** Database column key SqlType(text) */
    val key: Rep[String] = column[String]("key")
    /** Database column id SqlType(text) */
    val id: Rep[String] = column[String]("id")
    /** Database column attributes SqlType(text) */
    val attributes: Rep[String] = column[String]("attributes")
    /** Database column created SqlType(timestamp) */
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")

    /** Primary key of OpenidInfo (database name pk_openid_info) */
    val pk = primaryKey("pk_openid_info", (provider, key))
  }
  /** Collection-like TableQuery object for table OpenidInfo */
  lazy val OpenidInfo = new TableQuery(tag => new OpenidInfo(tag))

  /** Entity class storing rows of table PasswordInfo
   *  @param provider Database column provider SqlType(varchar), Length(64,true)
   *  @param key Database column key SqlType(text)
   *  @param hasher Database column hasher SqlType(varchar), Length(64,true)
   *  @param password Database column password SqlType(varchar), Length(256,true)
   *  @param salt Database column salt SqlType(varchar), Length(256,true), Default(None)
   *  @param created Database column created SqlType(timestamp) */
  case class PasswordInfoRow(provider: String, key: String, hasher: String, password: String, salt: Option[String] = None, created: java.sql.Timestamp)
  /** GetResult implicit for fetching PasswordInfoRow objects using plain SQL queries */
  implicit def GetResultPasswordInfoRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[PasswordInfoRow] = GR{
    prs => import prs._
    PasswordInfoRow.tupled((<<[String], <<[String], <<[String], <<[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table password_info. Objects of this class serve as prototypes for rows in queries. */
  class PasswordInfo(_tableTag: Tag) extends Table[PasswordInfoRow](_tableTag, "password_info") {
    def * = (provider, key, hasher, password, salt, created) <> (PasswordInfoRow.tupled, PasswordInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(provider), Rep.Some(key), Rep.Some(hasher), Rep.Some(password), salt, Rep.Some(created)).shaped.<>({r=>import r._; _1.map(_=> PasswordInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column provider SqlType(varchar), Length(64,true) */
    val provider: Rep[String] = column[String]("provider", O.Length(64,varying=true))
    /** Database column key SqlType(text) */
    val key: Rep[String] = column[String]("key")
    /** Database column hasher SqlType(varchar), Length(64,true) */
    val hasher: Rep[String] = column[String]("hasher", O.Length(64,varying=true))
    /** Database column password SqlType(varchar), Length(256,true) */
    val password: Rep[String] = column[String]("password", O.Length(256,varying=true))
    /** Database column salt SqlType(varchar), Length(256,true), Default(None) */
    val salt: Rep[Option[String]] = column[Option[String]]("salt", O.Length(256,varying=true), O.Default(None))
    /** Database column created SqlType(timestamp) */
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")

    /** Primary key of PasswordInfo (database name pk_password_info) */
    val pk = primaryKey("pk_password_info", (provider, key))
  }
  /** Collection-like TableQuery object for table PasswordInfo */
  lazy val PasswordInfo = new TableQuery(tag => new PasswordInfo(tag))

  /** Entity class storing rows of table Registration
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param extId Database column ext_id SqlType(varchar)
   *  @param createdOn Database column created_on SqlType(timestamp)
   *  @param idUsers Database column id_users SqlType(int8)
   *  @param idClazz Database column id_clazz SqlType(int4) */
  case class RegistrationRow(id: Int, extId: String, createdOn: java.sql.Timestamp, idUsers: Long, idClazz: Int)
  /** GetResult implicit for fetching RegistrationRow objects using plain SQL queries */
  implicit def GetResultRegistrationRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Long]): GR[RegistrationRow] = GR{
    prs => import prs._
    RegistrationRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp], <<[Long], <<[Int]))
  }
  /** Table description of table registration. Objects of this class serve as prototypes for rows in queries. */
  class Registration(_tableTag: Tag) extends Table[RegistrationRow](_tableTag, "registration") {
    def * = (id, extId, createdOn, idUsers, idClazz) <> (RegistrationRow.tupled, RegistrationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(createdOn), Rep.Some(idUsers), Rep.Some(idClazz)).shaped.<>({r=>import r._; _1.map(_=> RegistrationRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column id_users SqlType(int8) */
    val idUsers: Rep[Long] = column[Long]("id_users")
    /** Database column id_clazz SqlType(int4) */
    val idClazz: Rep[Int] = column[Int]("id_clazz")

    /** Foreign key referencing Clazz (database name clazz_fk) */
    lazy val clazzFk = foreignKey("clazz_fk", idClazz, Clazz)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Users (database name users_fk) */
    lazy val usersFk = foreignKey("users_fk", idUsers, Users)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name registration_ext_id_idx) */
    val index1 = index("registration_ext_id_idx", extId)
    /** Uniqueness Index over (idClazz) (database name registration_uq) */
    val index2 = index("registration_uq", idClazz, unique=true)
  }
  /** Collection-like TableQuery object for table Registration */
  lazy val Registration = new TableQuery(tag => new Registration(tag))

  /** Entity class storing rows of table Requests
   *  @param id Database column id SqlType(uuid), PrimaryKey
   *  @param authProvider Database column auth_provider SqlType(varchar), Length(64,true)
   *  @param authKey Database column auth_key SqlType(text)
   *  @param remoteAddress Database column remote_address SqlType(varchar), Length(64,true)
   *  @param method Database column method SqlType(varchar), Length(10,true)
   *  @param host Database column host SqlType(text)
   *  @param secure Database column secure SqlType(bool)
   *  @param path Database column path SqlType(text)
   *  @param queryString Database column query_string SqlType(text), Default(None)
   *  @param lang Database column lang SqlType(text), Default(None)
   *  @param cookie Database column cookie SqlType(text), Default(None)
   *  @param referrer Database column referrer SqlType(text), Default(None)
   *  @param userAgent Database column user_agent SqlType(text), Default(None)
   *  @param started Database column started SqlType(timestamp)
   *  @param duration Database column duration SqlType(int4)
   *  @param status Database column status SqlType(int4)
   *  @param idUsers Database column id_users SqlType(int8), Default(None) */
  case class RequestsRow(id: java.util.UUID, authProvider: String, authKey: String, remoteAddress: String, method: String, host: String, secure: Boolean, path: String, queryString: Option[String] = None, lang: Option[String] = None, cookie: Option[String] = None, referrer: Option[String] = None, userAgent: Option[String] = None, started: java.sql.Timestamp, duration: Int, status: Int, idUsers: Option[Long] = None)
  /** GetResult implicit for fetching RequestsRow objects using plain SQL queries */
  implicit def GetResultRequestsRow(implicit e0: GR[java.util.UUID], e1: GR[String], e2: GR[Boolean], e3: GR[Option[String]], e4: GR[java.sql.Timestamp], e5: GR[Int], e6: GR[Option[Long]]): GR[RequestsRow] = GR{
    prs => import prs._
    RequestsRow.tupled((<<[java.util.UUID], <<[String], <<[String], <<[String], <<[String], <<[String], <<[Boolean], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp], <<[Int], <<[Int], <<?[Long]))
  }
  /** Table description of table requests. Objects of this class serve as prototypes for rows in queries. */
  class Requests(_tableTag: Tag) extends Table[RequestsRow](_tableTag, "requests") {
    def * = (id, authProvider, authKey, remoteAddress, method, host, secure, path, queryString, lang, cookie, referrer, userAgent, started, duration, status, idUsers) <> (RequestsRow.tupled, RequestsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(authProvider), Rep.Some(authKey), Rep.Some(remoteAddress), Rep.Some(method), Rep.Some(host), Rep.Some(secure), Rep.Some(path), queryString, lang, cookie, referrer, userAgent, Rep.Some(started), Rep.Some(duration), Rep.Some(status), idUsers).shaped.<>({r=>import r._; _1.map(_=> RequestsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9, _10, _11, _12, _13, _14.get, _15.get, _16.get, _17)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(uuid), PrimaryKey */
    val id: Rep[java.util.UUID] = column[java.util.UUID]("id", O.PrimaryKey)
    /** Database column auth_provider SqlType(varchar), Length(64,true) */
    val authProvider: Rep[String] = column[String]("auth_provider", O.Length(64,varying=true))
    /** Database column auth_key SqlType(text) */
    val authKey: Rep[String] = column[String]("auth_key")
    /** Database column remote_address SqlType(varchar), Length(64,true) */
    val remoteAddress: Rep[String] = column[String]("remote_address", O.Length(64,varying=true))
    /** Database column method SqlType(varchar), Length(10,true) */
    val method: Rep[String] = column[String]("method", O.Length(10,varying=true))
    /** Database column host SqlType(text) */
    val host: Rep[String] = column[String]("host")
    /** Database column secure SqlType(bool) */
    val secure: Rep[Boolean] = column[Boolean]("secure")
    /** Database column path SqlType(text) */
    val path: Rep[String] = column[String]("path")
    /** Database column query_string SqlType(text), Default(None) */
    val queryString: Rep[Option[String]] = column[Option[String]]("query_string", O.Default(None))
    /** Database column lang SqlType(text), Default(None) */
    val lang: Rep[Option[String]] = column[Option[String]]("lang", O.Default(None))
    /** Database column cookie SqlType(text), Default(None) */
    val cookie: Rep[Option[String]] = column[Option[String]]("cookie", O.Default(None))
    /** Database column referrer SqlType(text), Default(None) */
    val referrer: Rep[Option[String]] = column[Option[String]]("referrer", O.Default(None))
    /** Database column user_agent SqlType(text), Default(None) */
    val userAgent: Rep[Option[String]] = column[Option[String]]("user_agent", O.Default(None))
    /** Database column started SqlType(timestamp) */
    val started: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("started")
    /** Database column duration SqlType(int4) */
    val duration: Rep[Int] = column[Int]("duration")
    /** Database column status SqlType(int4) */
    val status: Rep[Int] = column[Int]("status")
    /** Database column id_users SqlType(int8), Default(None) */
    val idUsers: Rep[Option[Long]] = column[Option[Long]]("id_users", O.Default(None))

    /** Foreign key referencing Users (database name users_fk) */
    lazy val usersFk = foreignKey("users_fk", idUsers, Users)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.SetNull)
  }
  /** Collection-like TableQuery object for table Requests */
  lazy val Requests = new TableQuery(tag => new Requests(tag))

  /** Entity class storing rows of table SessionInfo
   *  @param id Database column id SqlType(text), PrimaryKey
   *  @param provider Database column provider SqlType(varchar), Length(64,true)
   *  @param key Database column key SqlType(text)
   *  @param lastUsed Database column last_used SqlType(timestamp)
   *  @param expiration Database column expiration SqlType(timestamp)
   *  @param fingerprint Database column fingerprint SqlType(text), Default(None)
   *  @param created Database column created SqlType(timestamp) */
  case class SessionInfoRow(id: String, provider: String, key: String, lastUsed: java.sql.Timestamp, expiration: java.sql.Timestamp, fingerprint: Option[String] = None, created: java.sql.Timestamp)
  /** GetResult implicit for fetching SessionInfoRow objects using plain SQL queries */
  implicit def GetResultSessionInfoRow(implicit e0: GR[String], e1: GR[java.sql.Timestamp], e2: GR[Option[String]]): GR[SessionInfoRow] = GR{
    prs => import prs._
    SessionInfoRow.tupled((<<[String], <<[String], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table session_info. Objects of this class serve as prototypes for rows in queries. */
  class SessionInfo(_tableTag: Tag) extends Table[SessionInfoRow](_tableTag, "session_info") {
    def * = (id, provider, key, lastUsed, expiration, fingerprint, created) <> (SessionInfoRow.tupled, SessionInfoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(provider), Rep.Some(key), Rep.Some(lastUsed), Rep.Some(expiration), fingerprint, Rep.Some(created)).shaped.<>({r=>import r._; _1.map(_=> SessionInfoRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(text), PrimaryKey */
    val id: Rep[String] = column[String]("id", O.PrimaryKey)
    /** Database column provider SqlType(varchar), Length(64,true) */
    val provider: Rep[String] = column[String]("provider", O.Length(64,varying=true))
    /** Database column key SqlType(text) */
    val key: Rep[String] = column[String]("key")
    /** Database column last_used SqlType(timestamp) */
    val lastUsed: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("last_used")
    /** Database column expiration SqlType(timestamp) */
    val expiration: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("expiration")
    /** Database column fingerprint SqlType(text), Default(None) */
    val fingerprint: Rep[Option[String]] = column[Option[String]]("fingerprint", O.Default(None))
    /** Database column created SqlType(timestamp) */
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")

    /** Index over (provider,key) (database name idx_session_info_provider_key) */
    val index1 = index("idx_session_info_provider_key", (provider, key))
  }
  /** Collection-like TableQuery object for table SessionInfo */
  lazy val SessionInfo = new TableQuery(tag => new SessionInfo(tag))

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
   *  @param idAddress Database column id_address SqlType(int8)
   *  @param idUsers Database column id_users SqlType(int8), Default(None) */
  case class StudioRow(id: Long, extId: String, name: String, mobile: Option[Short] = None, phone: Short, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, isDeleted: Boolean = false, deletedReason: Option[String] = None, idAddress: Long, idUsers: Option[Long] = None)
  /** GetResult implicit for fetching StudioRow objects using plain SQL queries */
  implicit def GetResultStudioRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[Short]], e3: GR[Short], e4: GR[java.sql.Timestamp], e5: GR[Boolean], e6: GR[Option[String]], e7: GR[Option[Long]]): GR[StudioRow] = GR{
    prs => import prs._
    StudioRow.tupled((<<[Long], <<[String], <<[String], <<?[Short], <<[Short], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Boolean], <<?[String], <<[Long], <<?[Long]))
  }
  /** Table description of table studio. Objects of this class serve as prototypes for rows in queries. */
  class Studio(_tableTag: Tag) extends Table[StudioRow](_tableTag, "studio") {
    def * = (id, extId, name, mobile, phone, createdOn, updatedOn, isDeleted, deletedReason, idAddress, idUsers) <> (StudioRow.tupled, StudioRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(name), mobile, Rep.Some(phone), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(isDeleted), deletedReason, Rep.Some(idAddress), idUsers).shaped.<>({r=>import r._; _1.map(_=> StudioRow.tupled((_1.get, _2.get, _3.get, _4, _5.get, _6.get, _7.get, _8.get, _9, _10.get, _11)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column id_users SqlType(int8), Default(None) */
    val idUsers: Rep[Option[Long]] = column[Option[Long]]("id_users", O.Default(None))

    /** Foreign key referencing Address (database name address_fk) */
    lazy val addressFk = foreignKey("address_fk", idAddress, Address)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Users (database name users_fk) */
    lazy val usersFk = foreignKey("users_fk", idUsers, Users)(r => Rep.Some(r.id), onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.SetNull)

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
   *  @param isActive Database column is_active SqlType(bool), Default(true)
   *  @param idUsers Database column id_users SqlType(int8)
   *  @param idOffer Database column id_offer SqlType(int8)
   *  @param canceledOn Database column canceled_on SqlType(timestamp), Default(None) */
  case class SubscriptionRow(id: Long, extId: String, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, isActive: Boolean = true, idUsers: Long, idOffer: Long, canceledOn: Option[java.sql.Timestamp] = None)
  /** GetResult implicit for fetching SubscriptionRow objects using plain SQL queries */
  implicit def GetResultSubscriptionRow(implicit e0: GR[Long], e1: GR[String], e2: GR[java.sql.Timestamp], e3: GR[Boolean], e4: GR[Option[java.sql.Timestamp]]): GR[SubscriptionRow] = GR{
    prs => import prs._
    SubscriptionRow.tupled((<<[Long], <<[String], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<[Boolean], <<[Long], <<[Long], <<?[java.sql.Timestamp]))
  }
  /** Table description of table subscription. Objects of this class serve as prototypes for rows in queries. */
  class Subscription(_tableTag: Tag) extends Table[SubscriptionRow](_tableTag, "subscription") {
    def * = (id, extId, createdOn, updatedOn, isActive, idUsers, idOffer, canceledOn) <> (SubscriptionRow.tupled, SubscriptionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(createdOn), Rep.Some(updatedOn), Rep.Some(isActive), Rep.Some(idUsers), Rep.Some(idOffer), canceledOn).shaped.<>({r=>import r._; _1.map(_=> SubscriptionRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column ext_id SqlType(varchar) */
    val extId: Rep[String] = column[String]("ext_id")
    /** Database column created_on SqlType(timestamp) */
    val createdOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created_on")
    /** Database column updated_on SqlType(timestamp) */
    val updatedOn: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("updated_on")
    /** Database column is_active SqlType(bool), Default(true) */
    val isActive: Rep[Boolean] = column[Boolean]("is_active", O.Default(true))
    /** Database column id_users SqlType(int8) */
    val idUsers: Rep[Long] = column[Long]("id_users")
    /** Database column id_offer SqlType(int8) */
    val idOffer: Rep[Long] = column[Long]("id_offer")
    /** Database column canceled_on SqlType(timestamp), Default(None) */
    val canceledOn: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("canceled_on", O.Default(None))

    /** Foreign key referencing Offer (database name offer_fk) */
    lazy val offerFk = foreignKey("offer_fk", idOffer, Offer)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Users (database name users_fk) */
    lazy val usersFk = foreignKey("users_fk", idUsers, Users)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name subscription_ext_id_idx) */
    val index1 = index("subscription_ext_id_idx", extId)
    /** Uniqueness Index over (idUsers) (database name subscription_uq) */
    val index2 = index("subscription_uq", idUsers, unique=true)
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

  /** Entity class storing rows of table UserProfiles
   *  @param provider Database column provider SqlType(varchar), Length(64,true)
   *  @param key Database column key SqlType(text)
   *  @param email Database column email SqlType(varchar), Length(256,true), Default(None)
   *  @param firstName Database column first_name SqlType(varchar), Length(512,true), Default(None)
   *  @param lastName Database column last_name SqlType(varchar), Length(512,true), Default(None)
   *  @param fullName Database column full_name SqlType(varchar), Length(512,true), Default(None)
   *  @param avatarUrl Database column avatar_url SqlType(varchar), Length(512,true), Default(None)
   *  @param created Database column created SqlType(timestamp) */
  case class UserProfilesRow(provider: String, key: String, email: Option[String] = None, firstName: Option[String] = None, lastName: Option[String] = None, fullName: Option[String] = None, avatarUrl: Option[String] = None, created: java.sql.Timestamp)
  /** GetResult implicit for fetching UserProfilesRow objects using plain SQL queries */
  implicit def GetResultUserProfilesRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[java.sql.Timestamp]): GR[UserProfilesRow] = GR{
    prs => import prs._
    UserProfilesRow.tupled((<<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[String], <<?[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table user_profiles. Objects of this class serve as prototypes for rows in queries. */
  class UserProfiles(_tableTag: Tag) extends Table[UserProfilesRow](_tableTag, "user_profiles") {
    def * = (provider, key, email, firstName, lastName, fullName, avatarUrl, created) <> (UserProfilesRow.tupled, UserProfilesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(provider), Rep.Some(key), email, firstName, lastName, fullName, avatarUrl, Rep.Some(created)).shaped.<>({r=>import r._; _1.map(_=> UserProfilesRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column provider SqlType(varchar), Length(64,true) */
    val provider: Rep[String] = column[String]("provider", O.Length(64,varying=true))
    /** Database column key SqlType(text) */
    val key: Rep[String] = column[String]("key")
    /** Database column email SqlType(varchar), Length(256,true), Default(None) */
    val email: Rep[Option[String]] = column[Option[String]]("email", O.Length(256,varying=true), O.Default(None))
    /** Database column first_name SqlType(varchar), Length(512,true), Default(None) */
    val firstName: Rep[Option[String]] = column[Option[String]]("first_name", O.Length(512,varying=true), O.Default(None))
    /** Database column last_name SqlType(varchar), Length(512,true), Default(None) */
    val lastName: Rep[Option[String]] = column[Option[String]]("last_name", O.Length(512,varying=true), O.Default(None))
    /** Database column full_name SqlType(varchar), Length(512,true), Default(None) */
    val fullName: Rep[Option[String]] = column[Option[String]]("full_name", O.Length(512,varying=true), O.Default(None))
    /** Database column avatar_url SqlType(varchar), Length(512,true), Default(None) */
    val avatarUrl: Rep[Option[String]] = column[Option[String]]("avatar_url", O.Length(512,varying=true), O.Default(None))
    /** Database column created SqlType(timestamp) */
    val created: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("created")

    /** Index over (email) (database name user_profiles_email_idx) */
    val index1 = index("user_profiles_email_idx", email)
    /** Uniqueness Index over (provider,key) (database name user_profiles_provider_key_idx) */
    val index2 = index("user_profiles_provider_key_idx", (provider, key), unique=true)
  }
  /** Collection-like TableQuery object for table UserProfiles */
  lazy val UserProfiles = new TableQuery(tag => new UserProfiles(tag))

  /** Entity class storing rows of table Users
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
   *  @param isActive Database column is_active SqlType(bool), Default(true)
   *  @param inactiveReason Database column inactive_reason SqlType(varchar), Default(None)
   *  @param idAddress Database column id_address SqlType(int8)
   *  @param username Database column username SqlType(varchar), Default(None)
   *  @param profiles Database column profiles SqlType(text)
   *  @param roles Database column roles SqlType(varchar) */
  case class UsersRow(id: Long, extId: String, firstname: String, lastname: String, mobile: Option[String] = None, phone: Option[String] = None, email: Option[String] = None, emailVerified: Boolean = false, createdOn: java.sql.Timestamp, updatedOn: java.sql.Timestamp, ptoken: Option[String] = None, isDeleted: Boolean = false, deleteReason: Option[String] = None, isActive: Boolean = true, inactiveReason: Option[String] = None, idAddress: Long, username: Option[String] = None, profiles: String, roles: String)
  /** GetResult implicit for fetching UsersRow objects using plain SQL queries */
  implicit def GetResultUsersRow(implicit e0: GR[Long], e1: GR[String], e2: GR[Option[String]], e3: GR[Boolean], e4: GR[java.sql.Timestamp]): GR[UsersRow] = GR{
    prs => import prs._
    UsersRow.tupled((<<[Long], <<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<[Boolean], <<[java.sql.Timestamp], <<[java.sql.Timestamp], <<?[String], <<[Boolean], <<?[String], <<[Boolean], <<?[String], <<[Long], <<?[String], <<[String], <<[String]))
  }
  /** Table description of table users. Objects of this class serve as prototypes for rows in queries. */
  class Users(_tableTag: Tag) extends Table[UsersRow](_tableTag, "users") {
    def * = (id, extId, firstname, lastname, mobile, phone, email, emailVerified, createdOn, updatedOn, ptoken, isDeleted, deleteReason, isActive, inactiveReason, idAddress, username, profiles, roles) <> (UsersRow.tupled, UsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(extId), Rep.Some(firstname), Rep.Some(lastname), mobile, phone, email, Rep.Some(emailVerified), Rep.Some(createdOn), Rep.Some(updatedOn), ptoken, Rep.Some(isDeleted), deleteReason, Rep.Some(isActive), inactiveReason, Rep.Some(idAddress), username, Rep.Some(profiles), Rep.Some(roles)).shaped.<>({r=>import r._; _1.map(_=> UsersRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7, _8.get, _9.get, _10.get, _11, _12.get, _13, _14.get, _15, _16.get, _17, _18.get, _19.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
    /** Database column is_active SqlType(bool), Default(true) */
    val isActive: Rep[Boolean] = column[Boolean]("is_active", O.Default(true))
    /** Database column inactive_reason SqlType(varchar), Default(None) */
    val inactiveReason: Rep[Option[String]] = column[Option[String]]("inactive_reason", O.Default(None))
    /** Database column id_address SqlType(int8) */
    val idAddress: Rep[Long] = column[Long]("id_address")
    /** Database column username SqlType(varchar), Default(None) */
    val username: Rep[Option[String]] = column[Option[String]]("username", O.Default(None))
    /** Database column profiles SqlType(text) */
    val profiles: Rep[String] = column[String]("profiles")
    /** Database column roles SqlType(varchar) */
    val roles: Rep[String] = column[String]("roles")

    /** Foreign key referencing Address (database name address_fk) */
    lazy val addressFk = foreignKey("address_fk", idAddress, Address)(r => r.id, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Restrict)

    /** Index over (extId) (database name user_extid_idx) */
    val index1 = index("user_extid_idx", extId)
    /** Index over (profiles) (database name users_profiles_idx) */
    val index2 = index("users_profiles_idx", profiles)
    /** Index over (roles) (database name users_roles_idx) */
    val index3 = index("users_roles_idx", roles)
    /** Uniqueness Index over (idAddress) (database name users_uq) */
    val index4 = index("users_uq", idAddress, unique=true)
    /** Index over (username) (database name users_username_idx) */
    val index5 = index("users_username_idx", username)
  }
  /** Collection-like TableQuery object for table Users */
  lazy val Users = new TableQuery(tag => new Users(tag))
}
