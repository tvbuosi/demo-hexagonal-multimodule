package com.demo.hexagonal.web.handler

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

private val LOGGER: Logger = LoggerFactory.getLogger(ErrorMessageBuilder::class.java)

@Component
class ErrorMessageBuilder(private val messageSource: MessageSource) {

    fun buildMessage(prefix: String, vararg args: String = emptyArray()): ErrorCode {
        LOGGER.info("Creating error message...")
        return ErrorCode(
            code = getMessageFromResourceBundle(prefix, ErrorCodeEnum.CODE.suffix),
            message = getMessageFromResourceBundle(
                prefix, ErrorCodeEnum.MESSAGE.suffix, args.map { it }.toTypedArray()
            )
        ).also {
            LOGGER.info("Error message built successfully")
        }
    }

    private fun getMessageFromResourceBundle(
        prefix: String,
        suffix: String,
        args: Array<String> = arrayOf()
    ): String {
        val locale = LocaleContextHolder.getLocale()
        return messageSource.getMessage("${prefix}.${suffix}", args, locale)
    }
}