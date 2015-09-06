package models

case class Sms (
  clientId: String,
  senderMsisdn: String,
  recipient: String,
  message: String
)
