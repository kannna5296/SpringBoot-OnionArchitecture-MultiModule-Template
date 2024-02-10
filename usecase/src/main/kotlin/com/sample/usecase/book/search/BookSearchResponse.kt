package com.sample.usecase.book.search

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "書籍検索レスポンス")
class BookSearchResponse(
    @Schema(description = "書籍ID", example = "1")
    val id: String,
    @Schema(description = "書籍名", example = "ONE PIECE")
    val name: String,
    @Schema(description = "著者名", example = "尾田 栄一郎")
    val author: String,
) {
    constructor(dto: BookSearchDto) : this (
        id = dto.id.toString(),
        name = dto.name,
        author = dto.author,
    )
}
