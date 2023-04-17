package com.demo.hexagonal.web.interceptor.exception

class HeaderException(
    val prefix: String,
    vararg val args: String
) : RuntimeException()

object HeaderErrorCode {
    const val INVALID_TRACE_ID_HEADER = "invalid.header.trace-id.exception"
    const val INVALID_JWT_TOKEN_HEADER = "illegal.jwt.exception"
}