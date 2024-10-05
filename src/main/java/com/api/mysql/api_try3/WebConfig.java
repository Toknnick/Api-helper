package com.api.mysql.api_try3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Разрешить все пути
                .allowedOrigins("*") // Разрешить все источники
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Разрешить указанные HTTP-методы
                .allowedHeaders("Content-Type"); // Разрешить указанные заголовки
    }
}
