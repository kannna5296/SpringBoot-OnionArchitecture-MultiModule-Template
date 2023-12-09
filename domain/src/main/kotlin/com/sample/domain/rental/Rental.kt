package com.sample.domain.rental

import java.time.ZonedDateTime

class Rental(
    val userId: Int,
    val bookId: Int,
    val deadline: ZonedDateTime,
) {
    init {
        require(deadline.isAfter(ZonedDateTime.now()))
    }
}
