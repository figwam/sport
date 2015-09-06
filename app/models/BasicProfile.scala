package models

case class BasicProfile (
  firstName: Option[String] = None,
  lastName: Option[String] = None,
  language: Option[String] = None
)