package models

import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.db.DB
import play.api.Play.current
import models.Tables._

trait AddressDaoComponent {

  def insert(addressRow: AddressRow): Future[Int]
  def update(id: Long, addressRow: AddressRow): Future[Int]
  def delete(id: Long): Future[Int]
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[AddressRow]]
  def findById(id: Long): Future[AddressRow]
  def count: Future[Int]

}

object AddressDao extends AddressDaoComponent {

  private val address = TableQuery[Address]

  private def db: Database = Database.forDataSource(DB.getDataSource())

  /**
   * Filter addressRow with id
   */
  private def filterQuery(id: Long): Query[Address, AddressRow, Seq] =
    address.filter(_.id === id)

  /**
   * Count address with a filter
   */
  private def count(filter: String): Future[Int] =
    try db.run(address.filter(_.street.toLowerCase like filter.toLowerCase()).length.result)
    finally db.close

  /**
   * Count total address in database
   */
  override def count: Future[Int] =
    try db.run(address.length.result)
    finally db.close

  /**
   * Find addressRow by id
   */
  override def findById(id: Long): Future[AddressRow] =
    try db.run(filterQuery(id).result.head)
    finally db.close

  /**
   * Create a new addressRow
   */
  override def insert(addressRow: AddressRow): Future[Int] =
    try db.run(address += addressRow)
    finally db.close

  /**
   * Update addressRow with id
   */
  override def update(id: Long, addressRow: AddressRow): Future[Int] =
    try db.run(filterQuery(id).update(addressRow))
    finally db.close

  /**
   * Delete addressRow with id
   */
  override def delete(id: Long): Future[Int] =
    try db.run(filterQuery(id).delete)
    finally db.close

  /**
   * Return a page of address
   */
  override def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Future[Page[AddressRow]] = {
    try {
      val offset = pageSize * page
      val query =
        (for {
          addressRow <- address if addressRow.street.toLowerCase like filter.toLowerCase
        } yield (addressRow)).drop(offset).take(pageSize)
      val totalRows = count(filter)
      val result = db.run(query.result)
      result flatMap (address => totalRows map (rows => Page(address, page, offset, rows)))
    } finally { db.close() }
  }

}
