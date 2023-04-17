package com.demo.hexagonal.util

import com.demo.hexagonal.domain.exception.NotFoundErrorCode.ENUM_NOT_FOUND
import com.demo.hexagonal.domain.exception.NotFoundException


/**
 * Returns `true` if enum T contains an entry with the specified name.
 */
inline fun <reified T : Enum<T>> enumContains(value: String): Boolean {
    return enumValues<T>().any { it.name == value }
}

/**
 * Returns an enum entry with the specified name or throw exception if is null.
 */
inline fun <reified T : Enum<T>> enumValue(value: String): T {
    return enumValues<T>().find { it.name == value } ?: throw NotFoundException(
        ENUM_NOT_FOUND,
        value,
        T::class.java.simpleName
    )
}