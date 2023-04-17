package com.demo.hexagonal.web.validator

class UUIDValidator {
    companion object {
        @JvmStatic
        val UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"

        fun isUUID(email: String): Boolean {
            return UUID_REGEX.toRegex().matches(email);
        }
    }
}