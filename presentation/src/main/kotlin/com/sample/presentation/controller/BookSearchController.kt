package com.sample.presentation.controller

import com.sample.usecase.book.search.BookSearchForm
import com.sample.usecase.book.search.BookSearchResponse
import com.sample.usecase.book.search.BookSearchService
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookSearchController(
    private val service: BookSearchService
) {

    @GetMapping
    fun search(
        @RequestParam form: BookSearchForm,
        pageable: Pageable
    ): ResponseEntity<PageImpl<List<BookSearchResponse>>> {
        service.execute(form)
        return ResponseEntity.ok().build()
    }
}
