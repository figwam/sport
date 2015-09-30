package models.daos

import java.sql.Timestamp
import java.util._
import javax.inject.Inject

import models._
import play.Play
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait ClazzDefinitionDAO  {

  def insert(clazz: ClazzDefinition): Future[ClazzDefinition]
  //  def update(id: Long, clazz: ClazzDefinition): Future[Int]
  //  def delete(id: Long): Future[Int]
  def listActive(): Future[Seq[ClazzDefinition]]
  //  def findById(id: Long): Future[ClazzDefinition]
  def count: Future[Int]

}

class ClazzDefinitionDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends ClazzDefinitionDAO with DAOSlick {
  import driver.api._

  /**
   * Count employees with a filter
   */
  private def count(filter: String): Future[Int] =
    db.run(slickClazzDefinitions.filter(_.name.toLowerCase like filter.toLowerCase).length.result)

  /**
   * Count clazzes
   */
  override def count: Future[Int] =
    db.run(slickClazzDefinitions.length.result)


  override def insert(clazz: ClazzDefinition): Future[ClazzDefinition] = {
    val insertQuery = slickClazzDefinitions.returning(slickClazzDefinitions.map(_.id)).into((clazzDB, id) => clazzDB.copy(id = Some(id)))
    val objToInsert = DBClazzDefinition(None, UUID.randomUUID().toString, clazz.startFrom, clazz.endAt, clazz.activeFrom,clazz.activeTill, clazz.name, clazz.recurrence, clazz.contingent, new Timestamp(System.currentTimeMillis), new Timestamp(System.currentTimeMillis),Some(clazz.avatarurl),clazz.description, 2L)
    val action = insertQuery += objToInsert
    db.run(action).map(_ => clazz.copy(id = objToInsert.id))
  }


  override def listActive(): Future[Seq[ClazzDefinition]] = {
    val seeInAdvanceDays = Play.application().configuration().getString("days.see.clazzes.in.advance").toInt
    val nowRew: Calendar = new GregorianCalendar()
      nowRew.add(Calendar.DAY_OF_YEAR,seeInAdvanceDays)
    val now = new Timestamp(nowRew.getTimeInMillis)
    val query =
      for {
        clazz <- slickClazzDefinitions if clazz.activeFrom <= now
      } yield (clazz)
    val result = db.run(query.result)
    result.map { clazz =>
      clazz.map {
        case (clazz) => ClazzDefinition(clazz.id, UUID.fromString(clazz.extId), clazz.startFrom, clazz.endAt, clazz.activeFrom, clazz.activeTill, clazz.recurrence, clazz.name, clazz.contingent, clazz.avatarurl.get, clazz.description, clazz.idStudio)
      }
    }
  }

}
