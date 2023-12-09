package com.sample.presentation.controller

import com.sample.usecase.book.search.BookSearchForm
import com.sample.usecase.book.search.BookSearchResponse
import com.sample.usecase.book.search.BookSearchService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookSearchController(
    private val service: BookSearchService
) {

    @GetMapping
    fun search(
        @ModelAttribute form: BookSearchForm,
        pageable: Pageable
    ): ResponseEntity<Page<BookSearchResponse>> {
        val result = service.execute(form, pageable)
        return ResponseEntity.ok(result)
    }
}
