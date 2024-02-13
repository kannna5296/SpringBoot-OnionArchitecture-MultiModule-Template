package com.sample.usecase.book.detail

import java.time.OffsetDateTime

data class BookDetailDto(
    val id: Int?,
    val name: String?,
    val author: String?,
    val rentals: List<BookDetailRentalDto>?,
)

data class BookDetailRentalDto(
    val userId: Int,
    val rentedAt: OffsetDateTime,
    val deadline: OffsetDateTime,
    val isReturned: Boolean,
)
