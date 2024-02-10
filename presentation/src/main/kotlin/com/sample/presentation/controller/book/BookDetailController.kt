package com.sample.presentation.controller.book

import com.sample.usecase.book.detail.BookDetailResponse
import com.sample.usecase.book.detail.BookDetailService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "書籍情報")
class BookDetailController(private val service: BookDetailService) {

    @Operation(summary = "書籍情報詳細取得API")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "成功")])
    @GetMapping("/{bookId}")
    fun detail(
        @Parameter(description = "書籍ID", example = "1")
        @PathVariable(required = true)
        bookId: String
    ): ResponseEntity<BookDetailResponse> {
        val result = service.execute(bookId.toInt())
        return ResponseEntity.ok(result)
    }
}
