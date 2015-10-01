package utils

import java.sql.Timestamp
import java.util.{Date, Calendar, UUID, GregorianCalendar}

import models.{Recurrence, ClazzDefinition}
import org.scalatest.{GivenWhenThen, FeatureSpec}


/**
 * Created by alex on 27/09/15.
 */
class UtilsTest extends FeatureSpec with GivenWhenThen {

  info("As a Partner")
  info("I want to defince Clazzes with starting tim and stop time and active From and activeTill")
  info("So I can define the clazz once")
  info("And do the recurrent clazzes created automatically")

  feature("Create clazz definition") {
    scenario("Partner creates a clazz definition") {

      Given("A Util that calculates the recurrence")

      val startFrom = new GregorianCalendar
      startFrom.add(Calendar.DAY_OF_YEAR,-37)
      val endAt = new GregorianCalendar
      endAt.add(Calendar.DAY_OF_YEAR,-37)
      endAt.add(Calendar.HOUR,1)

      val activeFrom = new GregorianCalendar
      activeFrom.add(Calendar.YEAR, -2)
      val activeTill = new GregorianCalendar
      activeTill.add(Calendar.YEAR, 2)

      info("startFrom:"+startFrom.getTime)
      info("endAt:"+endAt.getTime)
      info("activeFrom:"+activeFrom.getTime)
      info("activeTill:"+activeTill.getTime)

      val clazzDef = ClazzDefinition(None, UUID.randomUUID(), new Timestamp(startFrom.getTimeInMillis), new Timestamp(endAt.getTimeInMillis), new Timestamp(activeFrom.getTimeInMillis), new Timestamp(activeTill.getTimeInMillis), Recurrence.WEEKLY,"Test Gym",5,"http://avatar","Super gym description","Crossfit", 1L)

      When("the next clazz appointment is calculated for valid weekly clazz")
      val clazzOption = Utils.calculateNextClazzes(clazzDef.recurrence, startFrom, endAt, 16, clazzDef)

      Then("the date must be in future")
      info(""+clazzOption.get.startFrom)
      info(""+clazzOption.get.endAt)
      assert(clazzOption.get.startFrom.after(new Date()))
      assert(clazzOption.get.endAt.after(new Date()))

      When("the next clazz appointment is calculated for outdated weekly clazz")
      activeTill.add(Calendar.YEAR, -3)
      clazzDef.copy(activeTill = new Timestamp(activeTill.getTimeInMillis))
      val clazzOption2 = Utils.calculateNextClazzes(clazzDef.recurrence, startFrom, endAt, 16, clazzDef)

      Then("the return must be None")
      assert(clazzOption2.get === None)
    }
  }

}