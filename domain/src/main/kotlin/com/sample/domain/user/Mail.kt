package com.sample.domain.user

// ValueObject例
data class Mail(val value: String) {

    init {
        require(value.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}"))) { " invalid-mail-address" }
    }
}
