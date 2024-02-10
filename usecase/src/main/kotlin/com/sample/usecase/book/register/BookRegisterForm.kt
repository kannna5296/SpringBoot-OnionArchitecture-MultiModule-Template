package com.sample.usecase.book.register

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "書籍登録フォーム")
data class BookRegisterForm(
    @Schema(description = "書籍名", example = "ONE PIECE")
    val name: String,
    @Schema(description = "著者名", example = "尾田 栄一郎")
    val author: String,
)
