package com.sample.presentation.controller.book

import com.sample.usecase.book.register.BookRegisterForm
import com.sample.usecase.book.register.BookRegisterService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
@Tag(name = "Book", description = "書籍情報")
class BookRegisterController(private val bookRegisterService: BookRegisterService) {

    @Operation(summary = "書籍情報登録API")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "成功")])
    @PostMapping
    fun register(@RequestBody param: BookRegisterForm): ResponseEntity<Void> {
        bookRegisterService.execute(param)
        return ResponseEntity.ok().build()
    }
}
