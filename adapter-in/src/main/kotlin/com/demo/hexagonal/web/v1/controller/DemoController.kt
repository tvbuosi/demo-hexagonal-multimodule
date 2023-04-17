package com.demo.hexagonal.web.v1.controller

import com.demo.hexagonal.component.PaginationData
import com.demo.hexagonal.util.enumValue

import java.util.UUID
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

object DemoControllerUrls {
    const val BASE_PATH = "/v1/"
}

private val LOGGER: Logger = LoggerFactory.getLogger(DemoController::class.java)

@RestController
@RequestMapping(DemoControllerUrls.BASE_PATH)
class DemoController(
    private val paginationData: PaginationData
) : DemoApi {

}