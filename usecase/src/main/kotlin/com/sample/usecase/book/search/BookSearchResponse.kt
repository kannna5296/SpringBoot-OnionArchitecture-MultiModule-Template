package com.sample.usecase.book.search

class BookSearchResponse(
    val name: String,
    val author: String,
) {
    constructor(dto: BookSearchDto) : this (
        name = dto.name,
        author = dto.author,
    )
}
