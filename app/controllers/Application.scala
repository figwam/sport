package controllers

import views._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models._
import java.util.concurrent.TimeoutException
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.i18n.Messages.Implicits._
import play.api.Play.current

class Application(dao: AddressDaoComponent) extends Controller {


  def index = Action { implicit request =>
    Ok("views.html.index()")
  }


  /**
   * Display the paginated list of employees.
   */
  def list(page: Int, orderBy: Int, filter: String): Action[AnyContent] = Action.async { implicit request =>
    dao.list(page, 10, orderBy, "%" + filter + "%").map { pageEmp =>
      Ok(html.list(pageEmp, orderBy, filter))
    }.recover {
      case ex: TimeoutException =>
        Logger.error("Problem found in employee list process")
        InternalServerError(ex.getMessage)
    }
  }

  /*  def createAddress = Action { implicit request =>
    val db = Database.forConfig("default")
    try {
      val q = Address.filter(_.id ===  5.toLong)
      db.run(q.result).map(_.foreach {
        case (row) =>
          println(" ------  " + row.street + "\t")
      })
      Ok("address created")
    } finally db.close
  }*/

}

object Application extends Application(AddressDao)