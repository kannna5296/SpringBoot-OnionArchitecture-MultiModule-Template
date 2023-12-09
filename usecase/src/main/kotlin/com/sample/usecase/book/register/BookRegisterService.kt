package com.sample.usecase.book.register

import com.sample.domain.book.Author
import com.sample.domain.book.Book
import com.sample.domain.book.IBookRepository
import com.sample.domain.book.Name
import org.springframework.stereotype.Service

@Service
class BookRegisterService(
    private val sampleRepository: IBookRepository
) {

    fun execute(form: BookRegisterForm) {

        // usecase層でやるちぇっくとあればいれる

        val book = Book(
            name = Name(form.name),
            author = Author(form.author),
            isRental = false, // マスタ登録時はレンタル関係ない
        )
        sampleRepository.insert(book)
    }
}
