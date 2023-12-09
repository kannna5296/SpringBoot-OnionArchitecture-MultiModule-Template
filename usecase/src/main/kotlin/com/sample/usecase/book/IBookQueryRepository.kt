package com.sample.usecase.book

import com.sample.usecase.book.detail.BookDetailDto
import com.sample.usecase.book.search.BookSearchDto
import com.sample.usecase.book.search.BookSearchForm

interface IBookQueryRepository {
    fun search(form: BookSearchForm, offset: Long, limit: Long): Pair<List<BookSearchDto>, Long> // 結果とヒット総数
    fun findById(bookId: Int): BookDetailDto?
}
