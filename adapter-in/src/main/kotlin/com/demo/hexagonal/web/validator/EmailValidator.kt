package com.demo.hexagonal.web.validator

class EmailValidator {
    companion object {
        @JvmStatic
        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        fun isEmail(email: String): Boolean {
            return EMAIL_REGEX.toRegex().matches(email);
        }
    }
}