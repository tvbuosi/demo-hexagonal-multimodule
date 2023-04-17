package com.demo.hexagonal.domain.exception

class NotFoundException(
    prefix: String,
    vararg args: String
) : BaseException(prefix, *args)

object NotFoundErrorCode {
    const val ENUM_NOT_FOUND = "enum.not.found.exception"
}