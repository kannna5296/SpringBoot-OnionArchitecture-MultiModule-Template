package com.sample.usecase.book.detail

import com.sample.usecase.book.IBookQueryRepository
import org.springframework.stereotype.Service

@Service
class BookDetailService(
    private val repository: IBookQueryRepository,
) {

    fun execute(bookId: Int): BookDetailResponse {
        val result = repository.findById(bookId) ?: throw IllegalArgumentException("book-not-found")
        return BookDetailResponse(result)
    }
}
