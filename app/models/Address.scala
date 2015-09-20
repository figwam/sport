package models

import java.util.UUID


case class Address(
                    id: Option[Long],
                    extId: UUID,
                    street: String,
                    city: String,
                    zip: String,
                    state: String,
                    country: String)
