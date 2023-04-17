package com.demo.hexagonal.web.validator

import io.kotest.matchers.shouldBe
import java.util.UUID
import org.junit.jupiter.api.Test

class UUIDValidatorTests {

    @Test
    fun `should validate uuid properly`() {

        val uuidList =
            listOf(
                "" to false,
                "1" to false,
                "58857e36-1a82-4a57-a064-a038ad0a90b" to false,
                "58857e36-1a82-4a57-a064-a038ad0a9b0b2" to false,
                "58857e36-1a82-4a57-a064-a038ad0a9b0b" to true,
                UUID.randomUUID().toString() to true,
            )

        uuidList.forEach { pair ->
            val verify = UUIDValidator.isUUID(pair.first)

            verify shouldBe pair.second
        }
    }
}