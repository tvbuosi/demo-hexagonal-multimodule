package com.demo.hexagonal.web.handler.response

import java.time.Instant


data class ErrorResponse(
    val timestamp: Instant = Instant.now(),
    val status: Int,
    val error: String,
    val code: String? = null,
    val message: String,
    val path: String
)
