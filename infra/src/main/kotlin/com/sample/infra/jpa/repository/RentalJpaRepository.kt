package com.sample.infra.jpa.repository

import com.sample.infra.jpa.entity.RentalJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RentalJpaRepository : JpaRepository<RentalJpaEntity, Int>
