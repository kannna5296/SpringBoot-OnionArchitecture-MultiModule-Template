package com.sample.infra.jpa.repository

import com.sample.infra.jpa.entity.RentalUserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RentalUserJpaRepository : JpaRepository<RentalUserJpaEntity, Int>
