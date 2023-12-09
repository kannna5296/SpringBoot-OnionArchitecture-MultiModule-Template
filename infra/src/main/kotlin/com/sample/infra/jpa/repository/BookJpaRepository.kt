package com.sample.infra.jpa.repository

import com.sample.infra.jpa.entity.BookJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BookJpaRepository : JpaRepository<BookJpaEntity, Int>
