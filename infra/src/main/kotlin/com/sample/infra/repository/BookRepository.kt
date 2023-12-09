package com.sample.infra.repository

import com.sample.domain.sampledomain.Book
import com.sample.domain.sampledomain.IBookRepository
import com.sample.infra.jpa.entity.BookJpaEntity
import com.sample.infra.jpa.repository.BookJpaRepository
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
    private val repository: BookJpaRepository
) : IBookRepository {

    override fun insert(book: Book) {
        repository.saveAndFlush(BookJpaEntity(book))
    }
}
