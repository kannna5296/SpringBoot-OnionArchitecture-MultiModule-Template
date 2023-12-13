package com.sample.usecase.rental.register

import com.sample.domain.book.IBookRepository
import com.sample.domain.rental.IRentalRepository
import com.sample.domain.user.IUserRepository
import com.sample.domain.user.Mail
import com.sample.domain.user.Name
import com.sample.domain.user.Phone
import com.sample.domain.user.RentalUser
import io.mockk.every
import io.mockk.mockk
import java.time.ZonedDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RentalRegisterServiceTest {

    private val userRepository = mockk<IUserRepository>()
    private val bookRepository = mockk<IBookRepository>()
    private val rentalRepository = mockk<IRentalRepository>()

    private val target = RentalRegisterService(
        userRepository = userRepository,
        bookRepository = bookRepository,
        rentalRepository = rentalRepository,
    )

    @Test
    fun `書籍が存在しないとエラー`() {
        every { userRepository.findById(any()) } returns RentalUser(
            id = 1,
            name = Name("name"),
            phone = Phone("phone"),
            mail = Mail("mail"),
        )
        every { bookRepository.findById(any()) } returns null
        val ex = assertFailsWith<IllegalArgumentException> {
            target.execute(
                RentalRegisterForm(
                    userId = 1,
                    bookId = 1,
                    deadline = ZonedDateTime.now(),
                )
            )
        }
        assertEquals("book-not-found", ex.message)
    }
}
