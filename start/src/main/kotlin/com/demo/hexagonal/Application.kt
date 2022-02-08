package com.demo.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.demo.hexagonal"])
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
