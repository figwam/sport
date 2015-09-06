import play.api._
import models._
import anorm._
import models.User

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    InitialData.insert()
  }
  
}

/**
 * Initial set of data to be imported 
 * in the sample application.
 */
object InitialData {
  
  def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)
  
  def insert() = {
    if(User.findAll.isEmpty) {
      Seq(
        User("alex", "Alexander", "alex", "united"),
        User("fabio", "Fabio", "fabio", "cyborg")
      ).foreach(User.create)
    }
  }
}