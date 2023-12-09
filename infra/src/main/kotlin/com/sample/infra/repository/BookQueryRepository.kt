package com.sample.infra.repository

import com.querydsl.jpa.impl.JPAQueryFactory
import com.sample.usecase.book.search.BookSearchDto
import com.sample.usecase.book.search.BookSearchForm
import com.sample.usecase.book.search.IBookQueryRepository
import org.springframework.stereotype.Repository

@Repository
class BookQueryRepository(
    private val queryFactory: JPAQueryFactory
) : IBookQueryRepository {

    override fun search(form: BookSearchForm): Pair<List<BookSearchDto>, Int> {
        TODO()
    }
}
