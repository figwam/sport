package models

case class JsonAddress (
  streetAddress: Option[String] = None,
  houseNumber: Option[String] = None,
  city: Option[String] = None,
  postalCode: Option[String] = None,
  country: Option[String] = None,
  houseName: Option[String] = None
)