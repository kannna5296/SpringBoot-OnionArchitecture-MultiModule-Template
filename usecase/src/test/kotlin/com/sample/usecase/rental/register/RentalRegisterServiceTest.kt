package com.sample.usecase.rental.register

import com.sample.domain.book.Author
import com.sample.domain.book.Book
import com.sample.domain.book.IBookRepository
import com.sample.domain.rental.IRentalRepository
import com.sample.domain.user.IUserRepository
import com.sample.domain.user.Mail
import com.sample.domain.user.Name
import com.sample.domain.user.RentalUser
import io.mockk.mockkClass
import io.mockk.every
import java.time.ZonedDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RentalRegisterServiceTest{

    private val userRepository = mockkClass(IUserRepository::class)
    private val bookRepository = mockkClass(IBookRepository::class)
    private val rentalRepository = mockkClass(IRentalRepository::class)

    private val service = RentalRegisterService(
        userRepository = userRepository,
        bookRepository = bookRepository,
        rentalRepository = rentalRepository,
    )

    private val form = RentalRegisterForm(
        userId = 1,
        bookId = 1,
        deadline = ZonedDateTime.of(2021, 1, 1, 0, 0, 0, 0, ZonedDateTime.now().zone),
    )

    @Test
    fun `ユーザがいない場合NG`() {
        every { userRepository.findById(any()) } returns null
        val ex = assertFailsWith<IllegalArgumentException> {  service.execute(form) }
        assertEquals("user-not-found", ex.message)
    }

    @Test
    fun `書籍がない場合NG`() {
        every { userRepository.findById(any()) } returns RentalUser(
            id = 1,
            name = Name("name"),
            phone = null,
            mail = Mail("mail"),
        )
        every { bookRepository.findById(any()) } returns null
        val ex = assertFailsWith<IllegalArgumentException> {  service.execute(form) }
        assertEquals("book-not-found", ex.message)
    }

    @Test
    fun `すでにレンタルされている書籍の場合NG`() {
        every { userRepository.findById(any()) } returns RentalUser(
            id = 1,
            name = Name("name"),
            phone = null,
            mail = Mail("mail"),
        )
        every { bookRepository.findById(any()) } returns Book(
            id = 1,
            name = com.sample.domain.book.Name("name"),
            author = Author("author"),
            isRental = true,
        )
        val ex = assertFailsWith<IllegalArgumentException> {  service.execute(form) }
        assertEquals("already-rente", ex.message)
    }
}
