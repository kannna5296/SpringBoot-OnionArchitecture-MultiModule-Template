package com.sample.presentation.controller.rental

import com.sample.usecase.rental.register.RentalRegisterForm
import com.sample.usecase.rental.register.RentalRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rental")
class RentalRegisterController(
    private val service: RentalRegisterService
) {

    @PostMapping
    fun register(@RequestBody param: RentalRegisterForm): ResponseEntity<Void> {
        service.execute(param)
        return ResponseEntity.ok().build()
    }
}
