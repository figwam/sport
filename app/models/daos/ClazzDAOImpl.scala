package models.daos

import java.sql.Timestamp
import java.util.UUID
import javax.inject.Inject

import models.Clazz
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.Future


class ClazzDAOImpl @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)
  extends ClazzDAO with DAOSlick {
  import driver.api._


  override def insert(clazz: Clazz): Future[Int] =
    try db.run(slickClazzes += DBClazz(None,UUID.randomUUID().toString,clazz.startFrom,clazz.endAt,clazz.name,clazz.contingent,new Timestamp(System.currentTimeMillis),new Timestamp(System.currentTimeMillis),2L))
    finally db.close


}
