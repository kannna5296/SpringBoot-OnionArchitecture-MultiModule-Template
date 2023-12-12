package com.sample.presentation.controller.book

import com.sample.usecase.book.detail.BookDetailResponse
import com.sample.usecase.book.detail.BookDetailService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookDetailController(
    private val service: BookDetailService
) {

    @GetMapping("/{bookId}")
    fun detail(@PathVariable(required = true) bookId: String): ResponseEntity<BookDetailResponse> {
        val result = service.execute(bookId.toInt())
        //　適当コメント、
        return ResponseEntity.ok(result)
    }
}
