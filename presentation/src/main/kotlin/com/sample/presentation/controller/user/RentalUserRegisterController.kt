package com.sample.presentation.controller.user

import com.sample.usecase.user.register.RentalUserRegisterForm
import com.sample.usecase.user.register.RentalUserRegisterService
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
@RequestMapping("/user")
@Tag(name = "RentalUser", description = "レンタルユーザ情報")
class RentalUserRegisterController(private val service: RentalUserRegisterService) {

    @Operation(summary = "レンタルユーザ情報登録API")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "成功")])
    @PostMapping
    fun register(@RequestBody param: RentalUserRegisterForm): ResponseEntity<Void> {
        service.execute(param)
        return ResponseEntity.ok().build()
    }
}
