package com.sample.domain.book

class Book(
    var id: Int? = null,
    val name: Name,
    val author: Author,
    val isRental: Boolean,
)
