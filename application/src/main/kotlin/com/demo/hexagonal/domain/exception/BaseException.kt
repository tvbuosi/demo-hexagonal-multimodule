package com.demo.hexagonal.domain.exception

open class BaseException(
    val prefix: String,
    vararg val args: String
) : RuntimeException()