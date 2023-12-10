package com.sample.infra.jpa.entity

import com.sample.domain.user.RentalUser
import java.time.OffsetDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "rental_user")
class RentalUserJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    val name: String? = null,
    val phone: String? = null,
    val mail: String? = null,
    val createdAt: OffsetDateTime? = OffsetDateTime.now(),
    val updatedAt: OffsetDateTime? = OffsetDateTime.now(),
) {
    constructor(rentalUser: RentalUser) : this(
        name = rentalUser.name.value,
        phone = rentalUser.phone.value,
        mail = rentalUser.mail.value,
    )
}
