package com.example.Produto.Controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // Use OAS_30 para OpenAPI 3.0
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.Produto.Controllers")) // Mapeia o pacote do controlador
                .paths(PathSelectors.any())
                .build();
    }
} 