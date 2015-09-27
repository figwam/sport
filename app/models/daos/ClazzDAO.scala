package models.daos

import models.Clazz

import scala.concurrent.Future

trait ClazzDAO  {

  def insert(clazz: Clazz): Future[Int]
  //  def update(id: Long, clazz: Clazz): Future[Int]
  //  def delete(id: Long): Future[Int]
  //  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[Clazz]]
  //  def findById(id: Long): Future[Clazz]
  //  def count: Future[Int]

}