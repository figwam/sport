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

  def insert(clazz: Clazz, idClazzDef: UUID): Future[Clazz]
  //  def update(id: Long, clazz: Clazz): Future[Int]
  //  def delete(id: Long): Future[Int]
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page]
  def listPersonalized(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%", idTrainee: UUID): Future[Page]
  //  def findById(id: Long): Future[Clazz]
  def count: Future[Int]

}

class ClazzDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends ClazzDAO with DAOSlick {
  import driver.api._


  private def count(filter: String): Future[Int] =
    db.run(slickClazzViews.filter(_.startFrom >= new Timestamp(System.currentTimeMillis())).filter(_.searchMeta.toLowerCase like filter.toLowerCase).length.result)

  /**
   * Count clazzes
   */
  override def count: Future[Int] =
    db.run(slickClazzes.filter(_.startFrom >= new Timestamp(System.currentTimeMillis())).length.result)


  override def insert(clazz: Clazz, idClazzDef: UUID): Future[Clazz] = {
    val insertQuery = slickClazzes.returning(slickClazzes.map(_.id)).into((clazzDB, id) => clazzDB.copy(id = id))
    val objToInsert = DBClazz(None, asTimestamp(clazz.startFrom), asTimestamp(clazz.endAt), new Timestamp(System.currentTimeMillis), new Timestamp(System.currentTimeMillis), idClazzDef)
    val action = insertQuery += objToInsert
    db.run(action).map(_ => clazz.copy(id = objToInsert.id))
  }

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
          Clazz(clazz.id, asCalendar(clazz.startFrom), asCalendar(clazz.endAt), clazz.name, clazz.contingent, clazz.avatarurl, clazz.description, clazz.tags, clazz.registrations, clazz.searchMeta, clazz.idClazzDef, clazz.idStudio, None)
        }
      } // The result is Seq[Clazz] flapMap (works with Clazz) these to Page
    }.flatMap (c3 => totalRows.map (rows => Page(c3, page, offset.toLong, rows.toLong)))
  }


  override def listPersonalized(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%", idTrainee: UUID): Future[Page] = {
    val offset = if (page > -1) pageSize * page else 0
    /*
    The following query is executed, which returns all personalized clazzes and additionally the reservation id.

        SELECT id, ext_id, start_from, end_at, name, contingent,
          avatarurl, description, tags, search_meta, nr_of_regs, id_clazzdef, id_studio, id_trainee, id_registration
        FROM (SELECT
                c.id AS cid,
                t.id AS id_trainee,
                r.id AS id_registration
              FROM clazz c, registration r, trainee t
              WHERE r.id_trainee = t.id AND r.id_clazz = c.id) a
          RIGHT OUTER JOIN clazz_view b
            ON b.id = a.cid and id_trainee = 4;
     */

    val regAction = (for {
      trainee <- slickTrainees
      reg <- slickRegistrations.filter(_.idTrainee === trainee.id).filter(_.idTrainee === idTrainee)
      clazz1 <- slickClazzes.filter(_.id === reg.idClazz)
    } yield (reg))


    val clazzAction = (for {
      (registration, clazz) <- regAction joinRight slickClazzViews
        .sortBy(r => orderBy match {case 1 => r.startFrom case _ => r.startFrom})
        .filter(_.searchMeta.toLowerCase like filter.toLowerCase) on (_.idClazz === _.id)

      //(clazz, registrations) <- slickClazzViews.sortBy(r => orderBy match {case 1 => r.startFrom case _ => r.startFrom}) joinRight slickRegistrations on (_.id === _.idClazz)
      //if clazz.startFrom >= new Timestamp(System.currentTimeMillis()) if clazz.searchMeta.toLowerCase like filter.toLowerCase
    } yield (clazz, registration)).drop(offset).take(pageSize)
    val totalRows = count(filter)


    val result = db.run(clazzAction.result)
    result.map { clazz =>
      clazz.map {
        // go through all the DBClazzes and map them to Clazz
        case (clazz, registration) => {
          val idReg: Option[UUID] = registration.flatMap{reg => reg match {case DBRegistration(_,_,_,_) => reg.id case _ => None} }
          Clazz(clazz.id, asCalendar(clazz.startFrom), asCalendar(clazz.endAt), clazz.name, clazz.contingent, clazz.avatarurl, clazz.description, clazz.tags, clazz.registrations, clazz.searchMeta, clazz.idClazzDef, clazz.idStudio, None)
        }
      } // The result is Seq[Clazz] flapMap (works with Clazz) these to Page
    }.flatMap (c3 => totalRows.map (rows => Page(c3, page, offset.toLong, rows.toLong)))
  }
}
