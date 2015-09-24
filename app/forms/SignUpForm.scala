package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data._
import validation.Constraints._
import play.api.libs.json.Json

/**
 * The form which handles the sign up process.
 */
object SignUpForm {

  /**
   * A play framework form.
   */
  val form = Form(
    mapping(
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText,
      "email" -> email,
      "password" -> nonEmptyText,
      "street" -> nonEmptyText,
      "city" -> nonEmptyText,
      "zip" -> text.verifying("falsche Eingabe", {_.toString.matches("\\d{4,4}")}),
      "state" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )

  /**
   * The form data.
   *
   * @param firstName The first name of a user.
   * @param lastName The last name of a user.
   * @param email The email of the user.
   * @param password The password of the user.
   */
  case class Data(
    firstname: String,
    lastname: String,
    email: String,
    password: String,
                   street: String,
                   city: String,
                   zip: String,
                   state: String)

  /**
   * The companion object.
   */
  object Data {

    /**
     * Converts the [Date] object to Json and vice versa.
     */
    implicit val jsonFormat = Json.format[Data]
  }
}
