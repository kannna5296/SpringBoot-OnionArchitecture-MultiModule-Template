package com.sample.usecase.book.register

import com.sample.domain.sampledomain.Author
import com.sample.domain.sampledomain.Book
import com.sample.domain.sampledomain.IBookRepository
import com.sample.domain.sampledomain.Name
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
        )
        sampleRepository.insert(book)
    }
}
