package com.demo.hexagonal.web.interceptor

import com.demo.hexagonal.component.FilterData
import com.demo.hexagonal.web.interceptor.enummerator.FilterEnum
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

private val LOGGER: Logger = LoggerFactory.getLogger(FilterInterceptor::class.java)

@Component
class FilterInterceptor(
    private val filterData: FilterData
) :
    HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        return FilterEnum.values().forEach {
            request.getParameter(it.filterName).let { param ->
                if (!param.isNullOrEmpty()) {
                    LOGGER.info("Interception to validate [${it.filterName}: $param, URI: ${request.requestURI}]")
                    it.addFilterIfExists(param, filterData)
                }
            }
        }.run { true }
    }
}