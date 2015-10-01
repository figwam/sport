package models

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.UUID

import models.Recurrence.Recurrence
import play.api.libs.json._

object Recurrence extends Enumeration {
  type Recurrence = Value
  val ONETIME, WEEKLY = Value
}

case class ClazzDefinition(
                  id: Option[Long],
                  extId: UUID,
                  startFrom: java.sql.Timestamp,
                  endAt: java.sql.Timestamp,
                  activeFrom: java.sql.Timestamp,
                  activeTill: java.sql.Timestamp,
                  recurrence: Recurrence,
                  name: String,
                  contingent: Short,
                  avatarurl: String,
                  description: String,
                  tags: String,
                  idStudio: Long)


/**
 * The companion object.
 */
object ClazzDefinition {
  implicit object timestampFormat extends Format[Timestamp] {
    val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'")
    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }
    def writes(ts: Timestamp) = JsString(format.format(ts))
  }
  implicit object recurrenceFormat extends Format[Recurrence] {
    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(Recurrence.withName(str))
    }
    def writes(r: Recurrence) = JsString(r+"")
  }
  /**
   * Converts the [Clazz] object to Json and vice versa.
   */
  implicit val jsonFormat = Json.format[Clazz]
}