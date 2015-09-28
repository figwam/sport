package modules

import com.google.inject.AbstractModule
import models.daos.{ClazzDAO, ClazzDAOImpl}
import net.codingwell.scalaguice.ScalaModule
import play.api.libs.concurrent.AkkaGuiceSupport
import scheduler.ClazzScheduler

/**
 * Created by alex on 28/09/15.
 */
class AkkaModule extends AbstractModule  with AkkaGuiceSupport{

  /**
   * Configures the module.
   */
  def configure() {
    bindActor[ClazzScheduler]("clazzActor")
  }
}
