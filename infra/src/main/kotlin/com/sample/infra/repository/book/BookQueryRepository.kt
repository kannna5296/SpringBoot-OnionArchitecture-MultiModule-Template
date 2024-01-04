package com.sample.infra.repository.book

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.infra.jpa.entity.QBookJpaEntity
import com.sample.infra.jpa.entity.QRentalJpaEntity
import com.sample.usecase.book.IBookQueryRepository
import com.sample.usecase.book.detail.BookDetailDto
import com.sample.usecase.book.detail.BookDetailRentalDto
import com.sample.usecase.book.search.BookSearchDto
import com.sample.usecase.book.search.BookSearchForm
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager

@Repository
class BookQueryRepository(
    private val queryFactory: JPAQueryFactory,
    private val entityManager: EntityManager,
) : IBookQueryRepository {

    private val book = QBookJpaEntity.bookJpaEntity
    private val rental = QRentalJpaEntity.rentalJpaEntity

    override fun search(form: BookSearchForm, offset: Long, limit: Long): Pair<List<BookSearchDto>, Long> {

        // お試し
//        val query0 = entityManager.createNativeQuery("SELECT * FROM get_rental_user(:name, :phone)")
//        query0.setParameter("name", form.name)
//        query0.setParameter("phone", null)
//        query0.resultList.forEach {
//            val array = it as Array<*>
//            if (array.isEmpty()) return@forEach
//            println(array[0] as Int)
//            println(array[1] as String)
//        }

        val query = queryFactory.select(
            book.id,
            book.name,
            book.author
        ).from(book)

        if (form.id != null) {
            query.where(book.id.eq(form.id?.toInt()))
        }

        if (!form.name.isNullOrEmpty()) {
            query.where(book.name.like("%" + form.name + "%"))
        }

        if (!form.author.isNullOrEmpty()) {
            query.where(book.author.like("%" + form.author + "%"))
        }

        val allResultSize = query.fetchCount() // TODO ライブラリ更新

        val fetchResult = query.offset(offset).limit(limit).fetch()

        val result = fetchResult.map {
            BookSearchDto(
                id = it.get(book.id)!!,
                name = it.get(book.name)!!,
                author = it.get(book.author)!!,
            )
        }

        return Pair(result, allResultSize)
    }

    override fun findById(bookId: Int): BookDetailDto? {
        val bookResult = queryFactory.select(
            book.id,
            book.name,
            book.author
        ).from(book).where(book.id.eq(bookId)).fetchOne() ?: return null

        val rentalList = queryFactory.select(
            rental.userId,
            rental.createdAt
        ).from(rental).where(rental.bookId.eq(bookId)).fetch()

        val rentalDto = rentalList.map {
            BookDetailRentalDto(
                userId = it.get(rental.userId)!!,
                rentedAt = it.get(rental.createdAt)!!,
            )
        }

        return BookDetailDto(
            id = bookResult.get(book.id),
            name = bookResult.get(book.name),
            author = bookResult.get(book.author),
            rentals = rentalDto,
        )
    }
}
