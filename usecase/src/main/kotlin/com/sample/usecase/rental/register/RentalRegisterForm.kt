package com.sample.usecase.rental.register

import java.time.ZonedDateTime

data class RentalRegisterForm(
    val bookId: Int,
    val userId: Int,
    val deadline: ZonedDateTime,
)
