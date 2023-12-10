package com.sample.domain.user

data class RentalUser(
    var id: Int? = null,
    val name: Name,
    val phone: Phone,
    val mail: Mail,
)
