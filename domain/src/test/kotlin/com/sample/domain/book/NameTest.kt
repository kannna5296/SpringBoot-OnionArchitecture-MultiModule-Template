package com.sample.domain.book


import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
class NameTest : StringSpec( {
    "array.size should return size of array" {
        val result = arrayOf("a", "b", "c")
        val expected = 3
        result.size shouldBe expected
    }
})