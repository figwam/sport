package models

import java.util.UUID

import play.api.libs.json._


case class Registration(
                         id: Option[Long],
                         extId: UUID,
                         idTrainee: Long,
                         idClazz: Long)


/**
 * The companion object.
 */
object Registration {

  /**
   * Converts the [Clazz] object to Json and vice versa.
   */
  implicit val jsonFormat = Json.format[Registration]
}