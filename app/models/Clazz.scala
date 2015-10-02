package models

import java.util.{GregorianCalendar, Calendar, UUID}

import play.api.libs.json._


case class Clazz(
                  id: Option[Long],
                  extId: UUID,
                  startFrom: Calendar,
                  endAt: Calendar,
                  name: String,
                  contingent: Short,
                  avatarurl: String,
                  description: String,
                  tags: Option[String],
                  registrations: Short = 0,
                  idClazzDef: Long)


/**
 * The companion object.
 */
object Clazz {

  import utils.Utils.Implicits._

  /**
   * Converts the [Clazz] object to Json and vice versa.
   */
  implicit val jsonFormat = Json.format[Clazz]
}