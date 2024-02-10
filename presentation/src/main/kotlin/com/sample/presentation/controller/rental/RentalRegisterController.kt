package com.sample.presentation.controller.rental

import com.sample.usecase.rental.register.RentalRegisterForm
import com.sample.usecase.rental.register.RentalRegisterService
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
@RequestMapping("/rental")
@Tag(name = "Rental", description = "レンタル情報")
class RentalRegisterController(private val service: RentalRegisterService) {

    @Operation(summary = "レンタル情報登録API")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "成功")])
    @PostMapping
    fun register(@RequestBody param: RentalRegisterForm): ResponseEntity<Void> {
        service.execute(param)
        return ResponseEntity.ok().build()
    }
}
