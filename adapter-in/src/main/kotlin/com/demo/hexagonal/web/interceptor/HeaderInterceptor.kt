package com.demo.hexagonal.web.interceptor

import com.demo.hexagonal.component.HeaderData
import com.demo.hexagonal.web.interceptor.enummerator.HeaderEnum
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

private val LOGGER: Logger = LoggerFactory.getLogger(HeaderInterceptor::class.java)

@Component
class HeaderInterceptor(
    private val headerData: HeaderData
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        return HeaderEnum.values().forEach {
            request.getHeader(it.headerName).apply {
                LOGGER.info("Interception to validate [${it.headerName}: $this, URI: ${request.requestURI}]")
                it.addHeaderIfExists(this, headerData)
            }
        }.run { true }
    }
}