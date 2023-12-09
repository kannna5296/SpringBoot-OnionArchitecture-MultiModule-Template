package com.sample.infra.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.infra.jpa.entity.QBookJpaEntity
import com.sample.usecase.book.search.BookSearchDto
import com.sample.usecase.book.search.BookSearchForm
import com.sample.usecase.book.search.IBookQueryRepository
import org.springframework.stereotype.Repository

@Repository
class BookQueryRepository(
    private val queryFactory: JPAQueryFactory
) : IBookQueryRepository {

    private val book = QBookJpaEntity.bookJpaEntity

    override fun search(form: BookSearchForm, offset: Long, limit: Long): Pair<List<BookSearchDto>, Long> {
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
}
