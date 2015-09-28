package models.daos

import java.sql.Timestamp
import java.util.UUID
import javax.inject.Inject

import models.Clazz
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait ClazzDAO  {

  def insert(clazz: Clazz): Future[Clazz]
  //  def update(id: Long, clazz: Clazz): Future[Int]
  //  def delete(id: Long): Future[Int]
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[Clazz]]
  //  def findById(id: Long): Future[Clazz]
  def count: Future[Int]

}

class ClazzDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends ClazzDAO with DAOSlick {
  import driver.api._

  /**
   * Count employees with a filter
   */
  private def count(filter: String): Future[Int] =
    try db.run(slickClazzes.filter(_.name.toLowerCase like filter.toLowerCase).length.result)
    finally db.close

  /**
   * Count clazzes
   */
  override def count: Future[Int] =
    try db.run(slickClazzes.length.result)
    finally db.close


  override def insert(clazz: Clazz): Future[Clazz] = {
    val insertQuery = slickClazzes.returning(slickClazzes.map(_.id)).into((clazzDB, id) => clazzDB.copy(id = Some(id)))
    val objToInsert = DBClazz(None, UUID.randomUUID().toString, clazz.startFrom, clazz.endAt, clazz.name, clazz.contingent, new Timestamp(System.currentTimeMillis), new Timestamp(System.currentTimeMillis), 2L)
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
  override def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[Clazz]] = {
    try {
      val offset = pageSize * page
      val query =
        (for {
          clazz <- slickClazzes if clazz.name.toLowerCase like filter.toLowerCase
        } yield (clazz)).drop(offset).take(pageSize)
      val totalRows = count(filter)
      val result = db.run(query.result)
      result.map { clazz => //result is Seq[DBClazz]
        clazz.map { // go through all the DBClazzes and map them to Clazz
          case (clazz) => Clazz(clazz.id, UUID.fromString(clazz.extId), clazz.startFrom, clazz.endAt, clazz.name, clazz.contingent, 2L)
        } // The result is Seq[Clazz] flapMap (works with Clazz) these to Page(...)
      }.flatMap (c3 => totalRows.map (rows => Page(c3, page, offset.toLong, rows.toLong)))
    } finally { db.close() }
  }

}
