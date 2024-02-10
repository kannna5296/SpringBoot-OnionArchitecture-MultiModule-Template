package com.sample.presentation.controller.user

import com.sample.usecase.user.update.RentalUserUpdateForm
import com.sample.usecase.user.update.RentalUserUpdateService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
@Tag(name = "RentalUser", description = "レンタルユーザ情報")
class RentalUserUpdateController(private val service: RentalUserUpdateService) {

    @Operation(summary = "レンタルユーザ情報更新API")
    @ApiResponses(value = [ApiResponse(responseCode = "200", description = "成功")])
    @PutMapping("/{userId}")
    fun update(
        @Parameter(description = "書籍ID", example = "1")
        @PathVariable(required = true) userId: String,
        @RequestBody param: RentalUserUpdateForm
    ): ResponseEntity<Void> {
        service.execute(userId.toInt(), param)
        return ResponseEntity.ok().build()
    }
}
