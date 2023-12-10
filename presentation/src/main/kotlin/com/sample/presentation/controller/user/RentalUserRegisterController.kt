package com.sample.presentation.controller.user

import com.sample.usecase.user.register.RentalUserRegisterForm
import com.sample.usecase.user.register.RentalUserRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class RentalUserRegisterController(
    private val service: RentalUserRegisterService
) {

    @PostMapping
    fun register(@RequestBody param: RentalUserRegisterForm): ResponseEntity<Void> {
        service.execute(param)
        return ResponseEntity.ok().build()
    }
}
