package com.demo.hexagonal.web.handler

import com.demo.hexagonal.domain.exception.BusinessException
import com.demo.hexagonal.domain.exception.NotFoundException
import com.demo.hexagonal.web.handler.response.ErrorResponse
import com.demo.hexagonal.web.interceptor.exception.HeaderException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.ServletWebRequest

private val LOGGER: Logger = LoggerFactory.getLogger(WebExceptionHandler::class.java)

@RestControllerAdvice
class WebExceptionHandler(private val errorMessageBuilder: ErrorMessageBuilder) {

    @ExceptionHandler(value = [NotFoundException::class])
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(ex: NotFoundException, request: ServletWebRequest): ErrorResponse {
        LOGGER.warn("Starting to handle a NotFoundException")
        val error = errorMessageBuilder.buildMessage(ex.prefix, *ex.args)
        val errorResponse = ErrorResponse(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.reasonPhrase,
            code = error.code,
            message = error.message,
            path = request.request.requestURI
        )
        LOGGER.warn("Responding NotFoundException for ${request.request.requestURI}")
        return errorResponse
    }

    @ExceptionHandler(value = [BusinessException::class])
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleNotFoundException(ex: BusinessException, request: ServletWebRequest): ErrorResponse {
        LOGGER.warn("Starting to handle a BusinessException")
        val error = errorMessageBuilder.buildMessage(ex.prefix, *ex.args)
        val errorResponse = ErrorResponse(
            status = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            error = HttpStatus.UNPROCESSABLE_ENTITY.reasonPhrase,
            code = error.code,
            message = error.message,
            path = request.request.requestURI
        )
        LOGGER.warn("Responding BusinessException for ${request.request.requestURI}")
        return errorResponse
    }

    @ExceptionHandler(value = [MissingServletRequestParameterException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleNotFoundException(
        ex: MissingServletRequestParameterException,
        request: ServletWebRequest
    ): ErrorResponse {
        LOGGER.warn("Starting to handle a MissingServletRequestParameterException")
        val errorResponse = ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            message = ex.message,
            path = request.request.requestURI
        )
        LOGGER.warn("Responding a bad request for ${request.request.requestURI}")
        return errorResponse
    }

    @ExceptionHandler(value = [HeaderException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleHeaderException(
        ex: HeaderException,
        request: ServletWebRequest
    ): ErrorResponse {
        LOGGER.warn("Starting to handle a HeaderException")
        val error = errorMessageBuilder.buildMessage(ex.prefix, *ex.args)
        val errorResponse = ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.reasonPhrase,
            code = error.code,
            message = error.message,
            path = request.request.requestURI
        )
        LOGGER.warn("Responding HeaderException for ${request.request.requestURI}")
        return errorResponse
    }
}