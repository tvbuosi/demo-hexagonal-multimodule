package com.demo.hexagonal.web.validator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class EmailValidatorTests {

    @Test
    fun `should validate email properly`() {

        val emailList =
            listOf(
                "" to false,
                "email" to false,
                "email@email" to false,
                "email@email.com" to true,
                "email@email.com.br" to true,
            )

        emailList.forEach { pair ->
            val verify = EmailValidator.isEmail(pair.first)

            verify shouldBe pair.second
        }
    }
}