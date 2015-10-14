package models

import java.util.{UUID, Calendar}

import play.api.libs.json._


case class Bill(
                  id: Option[UUID],
                  amount: scala.math.BigDecimal,
                  createdOn: Calendar,
                  vat: Short,
                  idTrainee: Long)


/**
 * The companion object.
 */
object Bill {

  import utils.Utils.Implicits._
  /**
   * Converts the [Bill] object to Json and vice versa.
   */
  implicit val jsonFormat = Json.format[Bill]
}