package com.demo.hexagonal.web.interceptor.config

import com.demo.hexagonal.web.interceptor.FilterInterceptor
import com.demo.hexagonal.web.interceptor.HeaderInterceptor
import com.demo.hexagonal.web.v1.controller.DemoControllerUrls
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfig(
    val filterInterceptor: FilterInterceptor,
    val headerInterceptor: HeaderInterceptor
) :
    WebMvcConfigurer {

    private fun addPatternUrls(interceptorRegistration: InterceptorRegistration) {
        interceptorRegistration
            .addPathPatterns("/**")
            .excludePathPatterns("/prometheus")
            .excludePathPatterns("/swagger-ui.html")
            .excludePathPatterns("/swagger-ui/**")
            .excludePathPatterns("/v2/api-docs/**")
            .excludePathPatterns("/swagger-resources/**")
            .excludePathPatterns("/metrics/**")
            .excludePathPatterns("/health/**")
            .excludePathPatterns("/info/**")
            .excludePathPatterns("/error/**")
            .excludePathPatterns(DemoControllerUrls.BASE_PATH + DemoControllerUrls.GROUPING_PATH)
            .excludePathPatterns(DemoControllerUrls.BASE_PATH + DemoControllerUrls.REVIEW_GENERATE_PATH)
            .excludePathPatterns(DemoControllerUrls.BASE_PATH + DemoControllerUrls.REVIEW_BY_DATE_PATH)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        addPatternUrls(registry.addInterceptor(filterInterceptor))
        addPatternUrls(registry.addInterceptor(headerInterceptor))
    }
}