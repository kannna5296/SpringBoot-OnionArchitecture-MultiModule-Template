package com.sample.domain.user

interface IUserRepository {
    fun insert(rentalUser: RentalUser)
    fun findById(userId: Int): Int?
}
