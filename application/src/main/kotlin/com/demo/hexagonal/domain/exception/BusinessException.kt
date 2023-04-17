package com.demo.hexagonal.domain.exception

import com.demo.hexagonal.domain.exception.BaseException

class BusinessException(
    prefix: String,
    vararg args: String
) : BaseException(prefix, *args)

object BusinessErrorCode {
    const val INVALID_UUID_FORMAT = "invalid.uuid.format.exception"
    const val FAILED_DESERIALIZE_TOKEN = "failed.deserialize.business.exception"
}