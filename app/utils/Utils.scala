package utils

import java.sql.Timestamp
import java.util.{GregorianCalendar, UUID, Calendar}

import models.Recurrence.Recurrence
import models.{Recurrence, Clazz, ClazzDefinition}
import play.Logger

/**
 * Created by alex on 01/10/15.
 */
object Utils {


  final def calculateNextClazzes(recurrence: Recurrence, startFrom: Calendar, endAt: Calendar, seeInAdvanceDays: Int, clazzDef: ClazzDefinition) : Option[Clazz] = {
    val now = new GregorianCalendar()
    recurrence match {
      case (Recurrence.WEEKLY) => {
        if (startFrom.before(now)){
          startFrom.add(Calendar.DAY_OF_YEAR,7)
          endAt.add(Calendar.DAY_OF_YEAR,7)
          calculateNextClazzes(recurrence,startFrom,endAt,seeInAdvanceDays,clazzDef)
        }
        else Some(Clazz(None, UUID.randomUUID(),new Timestamp(startFrom.getTimeInMillis), new Timestamp(endAt.getTimeInMillis), clazzDef.name,clazzDef.contingent,clazzDef.avatarurl,clazzDef.description,clazzDef.tags,clazzDef.idStudio))
      }
      case (Recurrence.ONETIME) => if (startFrom.after(now)) Some(Clazz(None, UUID.randomUUID(),new Timestamp(startFrom.getTimeInMillis), new Timestamp(endAt.getTimeInMillis), clazzDef.name,clazzDef.contingent,clazzDef.avatarurl,clazzDef.description,clazzDef.tags,clazzDef.idStudio)) else None
      case _ => Logger.warn("Unknown Recurrence type in clazz definition with id="+clazzDef.id); None
    }}
}
