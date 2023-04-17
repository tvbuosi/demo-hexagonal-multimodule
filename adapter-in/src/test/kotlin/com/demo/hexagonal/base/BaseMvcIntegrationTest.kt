package com.demo.hexagonal.base

import io.mockk.mockk
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc

@Tag("integration-test")
@WebMvcTest
@ContextConfiguration(classes = [TestConfig::class])
open class BaseMvcIntegrationTest {
    @Autowired
    lateinit var mockMvc: MockMvc
}

@SpringBootConfiguration
@ComponentScan(basePackages = ["com.demo.hexagonal.web", "com.demo.hexagonal.component"])
class TestConfig {

    @Bean
    fun demoUsecasePort(): DemoUsecasePort = mockk()
}