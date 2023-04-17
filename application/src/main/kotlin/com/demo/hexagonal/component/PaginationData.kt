package com.demo.hexagonal.component

import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.RequestScope

@Component
@RequestScope
class PaginationData {
    var pageable: Pageable? = null
    var total: Long? = null
}