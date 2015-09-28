package models

import java.util.UUID

import com.mohiva.play.silhouette.api.{ Identity, LoginInfo }

import java.sql.Timestamp
import java.text.SimpleDateFormat
import play.api.libs.json._


case class Clazz(
                  id: Option[Long],
                  extId: UUID,
                  startFrom: java.sql.Timestamp,
                  endAt: java.sql.Timestamp,
                  name: String,
                  contingent: Short,
                  idStudio: Long)


/**
 * The companion object.
 */
object Clazz {
  implicit object timestampFormat extends Format[Timestamp] {
    val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'")
    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }
    def writes(ts: Timestamp) = JsString(format.format(ts))
  }
  /**
   * Converts the [Clazz] object to Json and vice versa.
   */
  implicit val jsonFormat = Json.format[Clazz]
}