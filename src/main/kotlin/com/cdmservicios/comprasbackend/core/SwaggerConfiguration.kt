package com.cdmservicios.comprasbackend.core

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfiguration {

    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("comprasbackend-controller")
            .pathsToMatch("/api/**")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("ComprasCDM-Servicios API")
                    .description("Aplicativo web de compras")
                    .version("v1.0.0")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
            )
            .externalDocs(
                ExternalDocumentation()
                    .description("SpringShop Wiki Documentation")
                    .url("https://springshop.wiki.github.org/docs")
            )
    }
}