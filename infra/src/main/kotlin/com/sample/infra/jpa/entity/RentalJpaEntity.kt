package com.sample.infra.jpa.entity

import java.time.OffsetDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "rental")
class RentalJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    val bookId: Int? = null,
    val userId: Int? = null,
    val deadLine: OffsetDateTime? = null,
    val isReturned: Boolean? = null,
    val createdAt: OffsetDateTime? = OffsetDateTime.now(),
    val updatedAt: OffsetDateTime? = OffsetDateTime.now(),
)
