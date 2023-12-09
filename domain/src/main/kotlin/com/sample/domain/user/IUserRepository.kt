package com.sample.domain.user

interface IUserRepository {
    fun findById(userId: Int): Int?
}
