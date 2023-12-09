package com.sample.usecase.book.search

interface IBookQueryRepository {
    fun search(form: BookSearchForm): Pair<List<BookSearchDto>, Int> // 結果とヒット総数
}
