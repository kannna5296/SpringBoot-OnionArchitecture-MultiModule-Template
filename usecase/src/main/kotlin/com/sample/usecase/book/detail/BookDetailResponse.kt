package com.sample.usecase.book.detail

import java.time.ZonedDateTime

data class BookDetailResponse(
    val id: String,
    val name: String,
    val author: String,
    val rentals: List<BookDetailRentalResponse>,
) {
    constructor(dto: BookDetailDto) : this(
        id = dto.id.toString(),
        name = dto.name!!,
        author = dto.author!!,
        rentals = dto.rentals?.map {
            BookDetailRentalResponse(
                userId = it.userId.toString(),
                rentedAt = it.rentedAt.toZonedDateTime(),
            )
        }.orEmpty()
    )
}

data class BookDetailRentalResponse(
    val userId: String,
    val rentedAt: ZonedDateTime,
)
