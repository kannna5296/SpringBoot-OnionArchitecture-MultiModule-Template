package com.sample.usecase.user.register

import com.sample.domain.user.IUserRepository
import com.sample.domain.user.Mail
import com.sample.domain.user.Name
import com.sample.domain.user.Phone
import com.sample.domain.user.RentalUser
import org.springframework.stereotype.Service

@Service
class RentalUserRegisterService(
    private val repository: IUserRepository
) {

    fun execute(form: RentalUserRegisterForm) {

        // usecase層でやるちぇっくとあればいれる

        val user = RentalUser(
            name = Name(form.name),
            phone = Phone(form.phone),
            mail = Mail(form.mail),
        )
        repository.insert(user)
    }
}
