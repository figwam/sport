package scheduler

import java.sql.Timestamp
import java.util.{GregorianCalendar, Calendar, Date, UUID}

import akka.actor.{Cancellable, Actor}
import javax.inject.{Inject, Singleton}
import models._
import models.daos.{ClazzDefinitionDAO, ClazzDAO}
import play.api.Logger
import play.libs.Json

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration


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
        def calculateNextClazz(recurrence: String, startFrom: Calendar, endAt: Calendar, clazzDef: ClazzDefinition) : Clazz = {
          val now = new Timestamp(System.currentTimeMillis())
            if (recurrence.equals("WEEKLY")
              && startFrom.before(now)){
              startFrom.add(Calendar.DAY_OF_YEAR,7)
              endAt.add(Calendar.DAY_OF_YEAR,7)
              calculateNextClazz("WEEKLY",startFrom,endAt, clazzDef)
            } else Clazz(None, UUID.randomUUID(),new Timestamp(startFrom.getTimeInMillis), new Timestamp(endAt.getTimeInMillis), clazzDef.name,clazzDef.contingent,clazzDef.avatarurl,clazzDef.description,clazzDef.idStudio )
        }

        clazzDefinitionDAO.listActive().map { clazzDef =>
        clazzDef.map { clazzDef =>
          clazzDef.recurrence match {
            case ("WEEKLY") => {
              println("Create clazz"+Json.toJson(clazzDef))
              val startFrom = new GregorianCalendar
              startFrom.setTimeInMillis(clazzDef.startFrom.getTime)
              val endAt = new GregorianCalendar
              endAt.setTimeInMillis(clazzDef.endAt.getTime)

              clazzDAO.insert(calculateNextClazz(clazzDef.recurrence, startFrom, endAt,clazzDef))
                .map(c => println("Create clazzes inserted, with id="+c.id))
              println("Finally Create clazzes inserted")
            }
            case ("ONETIME") => {}
            case _ => Logger.warn("Recurrence type unknown: "+clazzDef.recurrence)
          }
        }


        }
      } catch {
        case t: Throwable =>
          t.printStackTrace()
      }
  }

}