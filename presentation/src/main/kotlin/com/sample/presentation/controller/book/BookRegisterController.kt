package com.sample.presentation.controller.book

import com.sample.usecase.book.register.BookRegisterForm
import com.sample.usecase.book.register.BookRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookRegisterController(
    private val bookRegisterService: BookRegisterService
) {

    @PostMapping
    fun register(@RequestBody param: BookRegisterForm): ResponseEntity<Void> {
        bookRegisterService.execute(param)
        return ResponseEntity.ok().build()
    }
}
