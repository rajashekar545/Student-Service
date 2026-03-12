package com.rajashekar.studentservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerApiConfig {

    @Bean
    public OpenAPI studentServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Service API")
                        .version("1.0")
                        .description("APIs for student management"));
    }
}