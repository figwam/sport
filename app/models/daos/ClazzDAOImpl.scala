package models.daos

import java.sql.Timestamp
import java.util.{GregorianCalendar, Calendar, UUID}
import javax.inject.Inject

import models.{ClazzDefinition, Clazz}
import play.Logger
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import utils.Utils.{asTimestamp, asCalendar}

trait ClazzDAO  {

  def insert(clazz: Clazz): Future[Clazz]
  //  def update(id: Long, clazz: Clazz): Future[Int]
  //  def delete(id: Long): Future[Int]
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page]
  //  def findById(id: Long): Future[Clazz]
  def count: Future[Int]

}

class ClazzDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends ClazzDAO with DAOSlick {
  import driver.api._


  private def count(filter: String): Future[Int] =
    db.run(slickClazzViews.filter(_.searchMeta.toLowerCase like filter.toLowerCase).length.result)

  /**
   * Count clazzes
   */
  override def count: Future[Int] =
    db.run(slickClazzes.length.result)


  override def insert(clazz: Clazz): Future[Clazz] = {
    val insertQuery = slickClazzes.returning(slickClazzes.map(_.id)).into((clazzDB, id) => clazzDB.copy(id = Some(id)))
    val objToInsert = DBClazz(None, UUID.randomUUID().toString, asTimestamp(clazz.startFrom), asTimestamp(clazz.endAt), new Timestamp(System.currentTimeMillis), new Timestamp(System.currentTimeMillis), clazz.idClazzDef)
    val action = insertQuery += objToInsert
    db.run(action).map(_ => clazz.copy(id = objToInsert.id))
  }

  /**
   * Return a page of clazzes
   * @param page
   * @param pageSize
   * @param orderBy
   * @param filter
   */
  /*
  override def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page] = {
    val offset = pageSize * page
    val clazzAction = (for {
      clazz <- slickClazzes if clazz.startFrom >= new Timestamp(System.currentTimeMillis()) if clazz.searchMeta.toLowerCase like filter.toLowerCase;
      clazzDef <- slickClazzDefinitions if clazzDef.id === clazz.idClazzDef
    } yield (clazz, clazzDef)).drop(offset).take(pageSize)
    val querySorted = orderBy match {
      case 1 => clazzAction.sortBy(r => r._1.startFrom) // means first element from yield, sort by date
      case -1 => clazzAction.sortBy(r => r._1.startFrom.desc)
      case _ => clazzAction.sortBy(r => r._1.startFrom)
    }
    val totalRows = count(filter)

    val result = db.run(querySorted.result)
    result.map { clazz => //result is Seq[DBClazz]
      clazz.map {
        // go through all the DBClazzes and map them to Clazz
        case (clazz, clazzDef) => {
          //Logger.info(clazzDef.name+"("+clazz.id+")-->"+registrations._2)
          Clazz(clazz.id, UUID.fromString(clazz.extId), asCalendar(clazz.startFrom), asCalendar(clazz.endAt), clazzDef.name, clazz.contingent, clazzDef.avatarurl.get, clazzDef.description, clazzDef.tags, 0, clazz.searchMeta, clazz.idClazzDef)
        }
      } // The result is Seq[Clazz] flapMap (works with Clazz) these to Page
    }.flatMap (c3 => totalRows.map (rows => Page(c3, page, offset.toLong, rows.toLong)))
  }
  */


  override def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page] = {
    val offset = if (page > -1) pageSize * page else 0
    val clazzAction = (for {
      clazz <- slickClazzViews.sortBy(r => orderBy match {case 1 => r.startFrom case _ => r.startFrom}) if clazz.startFrom >= new Timestamp(System.currentTimeMillis()) if clazz.searchMeta.toLowerCase like filter.toLowerCase

    } yield (clazz)).drop(offset).take(pageSize)
    val totalRows = count(filter)

    val result = db.run(clazzAction.result)
    result.map { clazz => //result is Seq[DBClazz]
      clazz.map {
        // go through all the DBClazzes and map them to Clazz
        case clazz => {
          //Logger.info(clazzDef.name+"("+clazz.id+")-->"+registrations._2)
          Clazz(clazz.id, UUID.fromString(clazz.extId), asCalendar(clazz.startFrom), asCalendar(clazz.endAt), clazz.name, clazz.contingent, clazz.avatarurl.get, clazz.description, clazz.tags, clazz.registrations, clazz.searchMeta, clazz.idClazzDef)
        }
      } // The result is Seq[Clazz] flapMap (works with Clazz) these to Page
    }.flatMap (c3 => totalRows.map (rows => Page(c3, page, offset.toLong, rows.toLong)))
  }

}
