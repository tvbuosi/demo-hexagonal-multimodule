package com.demo.hexagonal.web.handler

enum class ErrorCodeEnum(val suffix: String) {
    CODE("code"),
    MESSAGE("message")
}

data class ErrorCode(
    val code: String,
    val message: String
)
