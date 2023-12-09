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
            rental.isReturned
        ).from(book)
            .leftJoin(rental).on(rental.bookId.eq(book.id))
            .where(book.id.eq(bookId)).fetchOne() ?: return null

        // rentalれこーどがあるかつfalseのとき
        val isRental = bookResult.get(rental.isReturned) == false

        return Book(
            id = bookResult.get(book.id),
            name = Name(bookResult.get(book.name)!!),
            author = Author(bookResult.get(book.author)!!),
            isRental = isRental
        )
    }
}
