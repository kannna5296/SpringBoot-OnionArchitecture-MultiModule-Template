package com.sample.presentation.controller.book

import com.sample.usecase.book.search.BookSearchForm
import com.sample.usecase.book.search.BookSearchResponse
import com.sample.usecase.book.search.BookSearchService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "書籍情報")
class BookSearchController(private val service: BookSearchService) {

    @Operation(summary = "書籍情報検索API")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "成功")])
    @GetMapping
    fun search(
        @ModelAttribute form: BookSearchForm,
        pageable: Pageable
    ): ResponseEntity<Page<BookSearchResponse>> {
        val result = service.execute(form, pageable)
        return ResponseEntity.ok(result)
    }
}
