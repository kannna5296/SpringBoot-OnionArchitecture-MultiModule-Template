package com.sample.domain.user

interface IUserRepository {
    fun insert(rentalUser: RentalUser)
    fun update(rentalUser: RentalUser)
    fun findById(userId: Int): RentalUser?
}
