package com.demo.hexagonal.util

import com.demo.hexagonal.domain.exception.BusinessErrorCode
import com.demo.hexagonal.domain.exception.BusinessException
import java.util.UUID

fun String.toUUID(): UUID {
    try {
        return UUID.fromString(this)
    } catch (ex: IllegalArgumentException) {
        throw BusinessException(BusinessErrorCode.INVALID_UUID_FORMAT)
    }
}