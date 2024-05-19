package com.sample.presentation.controller.book

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime

@RestController
@RequestMapping("/")
@Tag(name = "Book", description = "書籍情報")
class TestController {

    @GetMapping("/test")
    fun get(@ModelAttribute form: TestForm) : ResponseEntity<Void> {
        println(form.zonedDateTime)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/test")
    fun post(@RequestBody req: TestRequest) : ResponseEntity<Void> {
        println(req.zonedDateTime)
        return ResponseEntity.ok().build()
    }
}

data class TestForm(
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val zonedDateTime: ZonedDateTime
)

data class TestRequest(
    val zonedDateTime: ZonedDateTime
)