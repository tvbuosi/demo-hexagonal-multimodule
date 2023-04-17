package com.demo.hexagonal.component

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class FilterData {
    var email: String? = null

    object Constants {
        const val email = "email"
    }
}