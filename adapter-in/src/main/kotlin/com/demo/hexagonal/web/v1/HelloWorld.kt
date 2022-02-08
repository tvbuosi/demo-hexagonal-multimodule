package com.demo.hexagonal.web.v1

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@Api(value = "Hello World")
@RestController
@RequestMapping("/v1/hello-world")
class HelloWorld() {

    @ApiOperation(value = "Return a hello world.")
    @ApiResponse(code = 200, message = "Ok")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun helloWorld(): String {
        return "hello world"
    }
}