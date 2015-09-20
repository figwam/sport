package forms

import play.api.data.Form
import play.api.data.Forms._
import play.api.data._
import validation.Constraints._

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
                   firstName: String,
                   lastName: String,
                   email: String,
                   password: String,
                   street: String,
                   city: String,
                   zip: String,
                   state: String)
}
