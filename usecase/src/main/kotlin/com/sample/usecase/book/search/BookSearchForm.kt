package com.sample.usecase.book.search

import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "書籍検索フォーム")
data class BookSearchForm(
    @field:Parameter(description = "書籍ID", example = "1")
    val id: String?,
    @field:Parameter(description = "書籍名", example = "ONE PIECE")
    val name: String?, // 部分一致
    @field:Parameter(description = "著者名", example = "尾田 栄一郎")
    val author: String?, // ぶぶん一致
)
