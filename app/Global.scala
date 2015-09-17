import java.text.SimpleDateFormat
import play.api._
import models._
import scala.concurrent.ExecutionContext.Implicits.global

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    StartData.insert()
  }

}

/**
 *  Starting set of data to be inserted into the sample application.
 */
object StartData {

  val sdf = new SimpleDateFormat("MM/dd/yyyy")

  def insert(): Unit = {
    AddressDao.count map { size =>
      if (size == 0) {
        val address = Seq()
        address.map(AddressDao.insert)
      }
    }
  }
}
