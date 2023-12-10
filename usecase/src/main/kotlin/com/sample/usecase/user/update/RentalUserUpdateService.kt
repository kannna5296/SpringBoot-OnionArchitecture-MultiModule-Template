package com.sample.usecase.user.update

import com.sample.domain.user.IUserRepository
import com.sample.domain.user.Mail
import com.sample.domain.user.Phone
import org.springframework.stereotype.Service

@Service
class RentalUserUpdateService(
    private val repository: IUserRepository
) {

    fun execute(userId: Int, form: RentalUserUpdateForm) {

        // usecase層でやるちぇっくとあればいれる

        val user = repository.findById(userId) ?: throw IllegalArgumentException("user-not-found")

        val editedUser = user.copy(
            phone = Phone(form.phone),
            mail = Mail(form.mail),
        )

        repository.update(editedUser)
    }
}
