package com.sample.domain.user

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class MailTest {

    @Test
    fun `インスタンス化可能`() {
        val input = "hoge@example.com"
        val mail = Mail(input)
        assertEquals(input, mail.value)
    }

    @Test
    fun `不正な文字列なのでインスタンス化できない`() {
        val input = "hogeexample.com"
        val ex = assertFailsWith<IllegalArgumentException> { Mail(input) }
        assertEquals(" invalid-mail-address", ex.message)
    }
}
