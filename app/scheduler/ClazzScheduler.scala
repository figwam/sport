package scheduler

import java.sql.Timestamp
import java.util.UUID

import akka.actor.{Cancellable, Actor}
import javax.inject.{Inject, Singleton}
import models.{Clazz}
import models.daos.{ClazzDAO}

import scala.concurrent.ExecutionContext.Implicits.global


/**
 * Created by alex on 27/09/15.
 */
@Singleton
class ClazzScheduler @Inject() (clazzDAO: ClazzDAO)  extends Actor {

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
        println("Create clazzes")
        clazzDAO.insert(Clazz(None, UUID.randomUUID(), new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),"random clazz",5,new Timestamp(System.currentTimeMillis()),new Timestamp(System.currentTimeMillis()),2L ))
      } catch {
        case t: Throwable =>
          println("Create clazzes failed")
      }
  }

}