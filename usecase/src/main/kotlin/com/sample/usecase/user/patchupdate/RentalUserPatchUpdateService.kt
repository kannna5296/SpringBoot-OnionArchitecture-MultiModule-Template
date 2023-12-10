package com.sample.usecase.user.patchupdate

import com.sample.domain.user.IUserRepository
import org.springframework.stereotype.Service
import javax.json.JsonPatch

@Service
class RentalUserPatchUpdateService(
    private val repository: IUserRepository
) {

    fun execute(userId: Int, request: JsonPatch) {

        // usecase層でやるちぇっくとあればいれる

        val user = repository.findById(userId) ?: throw IllegalArgumentException("user-not-found")

//        val editedUser = user.copy(
//            phone = Phone(form.phone),
//            mail = Mail(form.mail),
//        )
//
//        repository.update(editedUser)
    }
}
