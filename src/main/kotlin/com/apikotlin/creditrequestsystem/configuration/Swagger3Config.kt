package com.apikotlin.creditrequestsystem.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springdoc.core.models.GroupedOpenApi

@Configuration
class Swagger3Config {

    @Bean
    fun publicApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("credit-request-system-public")
            .pathsToMatch("/api/customers/**", "/api/credits/**")
            .build()
    }
}