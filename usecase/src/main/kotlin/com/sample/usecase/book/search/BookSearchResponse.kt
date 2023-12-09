package com.sample.usecase.book.search

class BookSearchResponse(
    val id: String,
    val name: String,
    val author: String,
) {
    constructor(dto: BookSearchDto) : this (
        id = dto.id.toString(),
        name = dto.name,
        author = dto.author,
    )
}
