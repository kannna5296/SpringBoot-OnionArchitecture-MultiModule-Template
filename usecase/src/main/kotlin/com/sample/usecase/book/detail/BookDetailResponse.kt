package com.sample.usecase.book.detail

import io.swagger.v3.oas.annotations.media.Schema
import java.time.ZonedDateTime

@Schema(description = "書籍詳細レスポンス")
data class BookDetailResponse(
    @Schema(description = "書籍ID", example = "1")
    val id: String,
    @Schema(description = "書籍名", example = "ONE PIECE")
    val name: String,
    @Schema(description = "著者名", example = "尾田 栄一郎")
    val author: String,
    @Schema(description = "レンタル可能")
    val canRental: Boolean,
    @Schema(description = "レンタル履歴")
    val rentals: List<BookDetailRentalResponse>,
) {
    constructor(dto: BookDetailDto) : this(
        id = dto.id.toString(),
        name = dto.name!!,
        author = dto.author!!,
        canRental = CanRentalConverter.convert(dto.rentals),
        rentals = dto.rentals.map {
            BookDetailRentalResponse(
                userId = it.userId.toString(),
                rentedAt = it.rentedAt.toZonedDateTime(),
                deadline = it.deadline.toZonedDateTime(),
                returned = it.isReturned,
            )
        }
    )
}

@Schema(description = "レンタル情報")
data class BookDetailRentalResponse(
    @Schema(description = "レンタルユーザID", example = "1")
    val userId: String,
    @Schema(description = "レンタル日付", example = "2023-01-01")
    val rentedAt: ZonedDateTime,
    @Schema(description = "返却期限", example = "2023-01-08")
    val deadline: ZonedDateTime,
    @Schema(description = "返却状況")
    val returned: Boolean,
)
