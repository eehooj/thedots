package com.example.tictoccroc.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPIInfo() {
        Info info = new Info()
                .title("API")
                .description("API Swagger 페이지입니다.");

        return new OpenAPI()
                .info(info);
    }
}
