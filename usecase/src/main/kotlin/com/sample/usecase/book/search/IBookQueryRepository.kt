package com.sample.usecase.book.search

interface IBookQueryRepository {
    fun search(form: BookSearchForm, offset: Long, limit: Long): Pair<List<BookSearchDto>, Long> // 結果とヒット総数
}
