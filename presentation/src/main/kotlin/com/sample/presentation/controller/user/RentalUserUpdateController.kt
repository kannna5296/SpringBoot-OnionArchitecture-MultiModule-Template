package com.sample.presentation.controller.user

import com.sample.usecase.user.update.RentalUserUpdateForm
import com.sample.usecase.user.update.RentalUserUpdateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class RentalUserUpdateController(
    private val service: RentalUserUpdateService
) {

    @PutMapping("/{userId}")
    fun register(
        @PathVariable(required = true) userId: String,
        @RequestBody param: RentalUserUpdateForm
    ): ResponseEntity<Void> {
        service.execute(userId.toInt(), param)
        return ResponseEntity.ok().build()
    }
}
