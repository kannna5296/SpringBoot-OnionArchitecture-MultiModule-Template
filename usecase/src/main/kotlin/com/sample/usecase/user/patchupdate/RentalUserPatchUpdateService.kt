package com.sample.usecase.user.patchupdate

import com.fasterxml.jackson.databind.ObjectMapper
import com.sample.domain.user.IUserRepository
import com.sample.domain.user.RentalUser
import org.springframework.stereotype.Service
import javax.json.JsonPatch

@Service
class RentalUserPatchUpdateService(
    private val repository: IUserRepository,
    private val mapper: JsonPatchMapper<RentalUserForJson> // RentalUserを持たせた方がいいかも？？
) {

    private val objectMapper = ObjectMapper()

    fun execute(userId: Int, request: JsonPatch) {

        // usecase層でやるちぇっくとあればいれる

        val user = repository.findById(userId) ?: throw IllegalArgumentException("user-not-found")
        val userJson = RentalUserForJson(
            id = user.id,
            name = user.name.value,
            phone = user.phone?.value,
            mail = user.mail.value,
        )
        println(objectMapper.writeValueAsString(userJson))

        val patch = mapper.apply(userJson, request)

//        val editedUser = user.copy(
//            phone = Phone(form.phone),
//            mail = Mail(form.mail),
//        )
//
//        repository.update(editedUser)
    }
}
