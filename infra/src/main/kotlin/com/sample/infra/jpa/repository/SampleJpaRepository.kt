package com.sample.infra.jpa.repository

import com.sample.infra.jpa.entity.Sample
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SampleJpaRepository: JpaRepository<Sample,Int>