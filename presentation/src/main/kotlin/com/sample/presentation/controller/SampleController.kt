package com.sample.presentation.controller

import com.sample.usecase.request.SampleForm
import com.sample.usecase.response.SampleResponse
import com.sample.usecase.service.SampleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val sampleService: SampleService
) {

    @PostMapping("/sample")
    fun create(@RequestBody param: SampleForm): ResponseEntity<SampleResponse> {
        return ResponseEntity.ok(sampleService.execute(param))
    }
}
