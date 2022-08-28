package com.sample.infra.jpa.repository

import com.sample.infra.jpa.entity.SampleJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SampleJpaRepository : JpaRepository<SampleJpaEntity, Int>
