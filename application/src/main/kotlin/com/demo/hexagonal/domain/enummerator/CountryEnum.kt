package com.demo.hexagonal.domain.enummerator

import com.demo.hexagonal.domain.exception.NotFoundErrorCode
import com.demo.hexagonal.domain.exception.NotFoundException

enum class CountryEnum(val abbreviation: String) {
    BRAZIL("BR")
}

fun countryEnumValueFromAbbreviation(value: String): CountryEnum {
    return enumValues<CountryEnum>().find { it.abbreviation == value }
        ?: throw NotFoundException(NotFoundErrorCode.ENUM_NOT_FOUND, value, CountryEnum::class.java.simpleName)
}

