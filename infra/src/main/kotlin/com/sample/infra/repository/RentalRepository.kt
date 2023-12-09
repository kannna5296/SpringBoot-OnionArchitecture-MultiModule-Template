package com.sample.infra.repository

import com.sample.domain.rental.IRentalRepository
import com.sample.domain.rental.Rental
import com.sample.infra.jpa.entity.RentalJpaEntity
import com.sample.infra.jpa.repository.RentalJpaRepository
import org.springframework.stereotype.Repository

@Repository
class RentalRepository(
    private val repository: RentalJpaRepository
) : IRentalRepository {

    override fun insert(rental: Rental) {
        repository.saveAndFlush(RentalJpaEntity(rental))
    }
}
