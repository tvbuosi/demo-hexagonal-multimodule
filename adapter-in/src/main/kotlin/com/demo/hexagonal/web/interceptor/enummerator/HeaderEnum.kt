package com.demo.hexagonal.web.interceptor.enummerator

import com.demo.hexagonal.component.HeaderData
import com.demo.hexagonal.util.toUUID
import com.demo.hexagonal.web.interceptor.exception.HeaderErrorCode
import com.demo.hexagonal.web.interceptor.exception.HeaderException

interface HeaderValues {
    fun addHeaderIfExists(headerValue: String?, headerData: HeaderData)
}

enum class HeaderEnum(
    val headerName: String
) : HeaderValues {

    TRACE_ID("trace-id") {
        override fun addHeaderIfExists(headerValue: String?, headerData: HeaderData) {
            if (headerValue.isNullOrEmpty())
                throw HeaderException(HeaderErrorCode.INVALID_TRACE_ID_HEADER)
            else
                headerData.traceId = headerValue.toUUID()
        }
    },
    AUTHORIZATION("Authorization") {
        override fun
                addHeaderIfExists(headerValue: String?, headerData: HeaderData) {
            if (headerValue.isNullOrEmpty() || !headerValue.startsWith("Bearer "))
                throw HeaderException(HeaderErrorCode.INVALID_JWT_TOKEN_HEADER)
            else
                headerData.authorization.deserialize(headerValue)
        }
    }
}