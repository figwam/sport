package models

import java.util.UUID

import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }


case class User(
   id: Option[Long],
   loginInfo: LoginInfo,
   extId: UUID,
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
   username: Option[String] = None,
   profiles: String,
   roles: String,
   fullname: Option[String] = None,
   avatarurl: Option[String] = None,
   address: Address) extends Identity
