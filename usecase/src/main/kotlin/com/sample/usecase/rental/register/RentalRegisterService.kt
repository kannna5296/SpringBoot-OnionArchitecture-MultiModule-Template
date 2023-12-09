package com.sample.usecase.rental.register

import com.sample.domain.book.IBookRepository
import com.sample.domain.rental.IRentalRepository
import com.sample.domain.rental.Rental
import com.sample.domain.user.IUserRepository
import org.springframework.stereotype.Service

@Service
class RentalRegisterService(
    private val userRepository: IUserRepository,
    private val bookRepository: IBookRepository,
    private val rentalRepository: IRentalRepository,
) {

    fun execute(form: RentalRegisterForm) {

        userRepository.findById(form.userId) ?: throw IllegalArgumentException("存在しないユーザなのでレンタルできません")

        val book = bookRepository.findById(form.bookId) ?: throw IllegalArgumentException("存在しない書籍なのでレンタルできません")

        if (book.isRental) throw IllegalArgumentException("すでに貸出中なのでレンタルできません")

        val rental = Rental(
            userId = form.userId,
            bookId = form.bookId,
            deadline = form.deadline,
        )
        rentalRepository.insert(rental)
    }
}
