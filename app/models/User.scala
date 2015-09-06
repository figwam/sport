package models

import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._
import scala.language.postfixOps
import play.Logger

case class User(username: String, name: String, password: String, theme: String)

object User {
  
  // -- Parsers
  
  /**
   * Parse a User from a ResultSet
   */
  val simple = {
    get[String]("user.username") ~
    get[String]("user.name") ~
    get[String]("user.password") ~
    get[String]("user.theme") map {
      case username~name~password~theme => User(username, name, password, theme)
    }
  }
  
  // -- Queries
  
  /**
   * Retrieve a User from username.
   */
  def findByUsername(username: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user where username = {username}").on(
        'username -> username
      ).as(User.simple.singleOpt)
    }
  }
  
  /**
   * Retrieve all users.
   */
  def findAll: Seq[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from user").as(User.simple *)
    }
  }
  
  /**
   * Authenticate a User.
   */
  def authenticate(username: String, password: String): Option[User] = {
    DB.withConnection { implicit connection =>
      val u = SQL(
        """
         select * from user where 
         username = {username} and password = {password}
        """
      ).on(
        'username -> username,
        'password -> password
      ).as(User.simple.singleOpt)
      Logger.info("Login User: "+u.getOrElse("NO_USER").toString())
      u
    }
  }
   
  /**
   * Create a User.
   */
  def create(user: User): User = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into user values (
            {username}, {name}, {password}, {theme}
          )
        """
      ).on(
        'username -> user.username,
        'name -> user.name,
        'password -> user.password,
        'theme -> user.theme
      ).executeUpdate()
      
      user
      
    }
  }
  
}
