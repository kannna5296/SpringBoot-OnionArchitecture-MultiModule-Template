package com.sample.usecase.book.search

data class BookSearchForm(
    val id: String?,
    val name: String?, // 部分一致
    val author: String?, // ぶぶん一致
)
