package models.daos

import java.sql.Timestamp
import java.util.UUID
import javax.inject.Inject

import models.Clazz
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future

trait ClazzDAO  {

  def insert(clazz: Clazz): Future[Int]
  //  def update(id: Long, clazz: Clazz): Future[Int]
  //  def delete(id: Long): Future[Int]
  //  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[Clazz]]
  //  def findById(id: Long): Future[Clazz]
  //  def count: Future[Int]

}

class ClazzDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends ClazzDAO with DAOSlick {
  import driver.api._


  override def insert(clazz: Clazz): Future[Int] =
    try db.run(slickClazzes += DBClazz(None,UUID.randomUUID().toString,clazz.startFrom,clazz.endAt,clazz.name,clazz.contingent,new Timestamp(System.currentTimeMillis),new Timestamp(System.currentTimeMillis),2L))
    finally db.close


}
