package com.demo.hexagonal.web.interceptor.enummerator

import com.demo.hexagonal.component.FilterData
import com.demo.hexagonal.util.toUUID
import com.demo.hexagonal.web.validator.EmailValidator
import com.demo.hexagonal.web.validator.UUIDValidator

interface FilterValues {
    fun addFilterIfExists(filterValue: String, filterData: FilterData)
}

enum class FilterEnum(
    val filterName: String
) : FilterValues {

    QUERY("query") {
        override fun addFilterIfExists(filterValue: String, filterData: FilterData) {

            if (EmailValidator.isEmail(filterValue))
                filterData.email = filterValue
            else if (UUIDValidator.isUUID(filterValue))
                filterData.campaignId = filterValue.toUUID()
            else
                filterData.tag = filterValue
        }
    },
    COST_CENTER_ID("costCenterId") {
        override fun addFilterIfExists(filterValue: String, filterData: FilterData) {
            filterData.costCenterId = filterValue.toInt()
        }
    }
}