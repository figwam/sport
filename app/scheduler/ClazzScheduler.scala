package scheduler

import org.postgresql.util.PSQLException
import play.Play
import utils._
import java.util.{GregorianCalendar, Calendar, Date, UUID}

import akka.actor.{Cancellable, Actor}
import javax.inject.{Inject, Singleton}
import models.daos.{ClazzDefinitionDAO, ClazzDAO}
import play.api.Logger
import play.libs.Json

import models.Recurrence._

import scala.concurrent.ExecutionContext.Implicits.global


/**
 * Created by alex on 27/09/15.
 */
@Singleton
class ClazzScheduler @Inject() (clazzDAO: ClazzDAO, clazzDefinitionDAO: ClazzDefinitionDAO)  extends Actor {

  private val CREATE_CLAZZES = "CREATE_CLAZZES"

  private var scheduler: Cancellable = _

  override def preStart(): Unit = {
    import scala.concurrent.duration._
    scheduler = context.system.scheduler.schedule(
      initialDelay = 5.seconds,
      interval = 5.seconds,
      receiver = self,
      message = CREATE_CLAZZES
    )
  }

  override def postStop(): Unit = {
    scheduler.cancel()
  }

  def receive = {
    case CREATE_CLAZZES =>
      try {
        val seeInAdvanceDays = Play.application().configuration().getString("days.see.clazzes.in.advance").toInt
        val clazzes =  clazzDefinitionDAO.listActive()
        Logger.debug("Execute Cron "+CREATE_CLAZZES+":"+Json.toJson(clazzes))
        clazzes.map { clazzDef =>
          clazzDef.map { clazzDef =>
            clazzDef.recurrence match {
              case (WEEKLY) => {
                Logger.debug("Create clazz"+Json.toJson(clazzDef))
                val startFrom = new GregorianCalendar
                startFrom.setTimeInMillis(clazzDef.startFrom.getTime)
                val endAt = new GregorianCalendar
                endAt.setTimeInMillis(clazzDef.endAt.getTime)
                val activeFrom = new GregorianCalendar
                activeFrom.setTimeInMillis(clazzDef.activeFrom.getTime)
                val activeTill = new GregorianCalendar
                activeTill.setTimeInMillis(clazzDef.activeTill.getTime)

                Utils.calculateNextClazzes(clazzDef.recurrence, startFrom, endAt, seeInAdvanceDays, clazzDef) match {
                  case Some(clazz) => {
                    val future = clazzDAO.insert(clazz).map(c => Logger.debug("Create clazzes inserted, with id="+c.id))
                    future.onSuccess { case a => Logger.debug(s"Class created: $a") }
                    future.onFailure {
                      case t: PSQLException => Logger.warn("Class already exists"+t.getMessage)
                      case t: Throwable => Logger.error(t.getMessage,t)
                    }
                  }
                  case _ => Logger.warn("outdated clazz definition found, id="+clazzDef.id)
                }
              }
              case (ONETIME) => {}
              case _ => Logger.warn("Recurrence type unknown: "+clazzDef.recurrence);
            }
          }
        }
        Logger.debug("Finished Cron "+CREATE_CLAZZES+":"+Json.toJson(clazzes))
        clazzes.onSuccess { case a => Logger.debug(s"Classes created: $a") }
        clazzes.onFailure { case t: Throwable => Logger.error(t.getMessage,t) }
      } catch {
        case t: Throwable =>
          Logger.error(t.getMessage,t)
      }
  }

}