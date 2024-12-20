package com.example.Produto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Permitir todas as rotas
                .allowedOrigins("http://localhost:3000")  // URL do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Métodos permitidos
                .allowedHeaders("*")  // Permitir todos os cabeçalhos
                .allowCredentials(true);  // Permitir enviar cookies ou autenticação
    }
}
