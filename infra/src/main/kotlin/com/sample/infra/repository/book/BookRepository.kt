package com.sample.infra.repository.book

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.domain.book.Author
import com.sample.domain.book.Book
import com.sample.domain.book.IBookRepository
import com.sample.domain.book.Name
import com.sample.infra.jpa.entity.BookJpaEntity
import com.sample.infra.jpa.entity.QBookJpaEntity
import com.sample.infra.jpa.entity.QRentalJpaEntity
import com.sample.infra.jpa.repository.BookJpaRepository
import com.sample.usecase.book.detail.BookDetailRentalDto
import org.springframework.stereotype.Repository

@Repository
class BookRepository(
    private val repository: BookJpaRepository,
    private val queryFactory: JPAQueryFactory
) : IBookRepository {

    private val book = QBookJpaEntity.bookJpaEntity
    private val rental = QRentalJpaEntity.rentalJpaEntity

    override fun insert(book: Book) {
        repository.saveAndFlush(BookJpaEntity(book))
    }

    override fun findById(bookId: Int): Book? {
        val bookResult = queryFactory.select(
            book.id,
            book.name,
            book.author,
        ).from(book)
            .where(book.id.eq(bookId)).fetchOne() ?: return null

        // rentalれこーどがあるかつfalseのとき
        val rentalList = queryFactory.select(
                rental.isReturned,
        ).from(rental).where(rental.bookId.eq(bookId)).fetch()

        val isRental =  rentalList.any { it != true }

        return Book(
            id = bookResult.get(book.id),
            name = Name(bookResult.get(book.name)!!),
            author = Author(bookResult.get(book.author)!!),
            isRental = isRental
        )
    }
}
