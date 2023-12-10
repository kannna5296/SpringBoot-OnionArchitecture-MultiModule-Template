package com.sample.presentation.controller.user.patch

import com.sample.usecase.user.patchupdate.RentalUserPatchUpdateForm
import com.sample.usecase.user.patchupdate.RentalUserPatchUpdateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.json.JsonPatch;

@RestController
@RequestMapping("/user")
class RentalUserPatchUpdateController(
    private val service: RentalUserPatchUpdateService,
    private val mapper: JsonPatchMapper<RentalUserPatchUpdateForm> // RentalUserを持たせた方がいいかも？？
) {

    @PatchMapping("/{userId}", consumes = ["application/json-patch+json"])
    fun patchUpdate(
        @PathVariable(required = true) userId: String,
        @RequestBody request: JsonPatch
    ): ResponseEntity<Void> {
        service.execute(userId.toInt(), request)
        return ResponseEntity.ok().build()
    }
}
