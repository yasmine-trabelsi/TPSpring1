package com.example.demo.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());

    }

    public Info infoAPI() {
        return new Info().title("\uD83C\uDFBF demo MANAGEMENT \uD83D\uDEA0")
                .description("Case Study - demo")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        return new Contact().name("TEAM ASI II")
                .email("yasmine.trabelsi@esprit.tn")
                .url("https://www.linkedin.com/in/yasmine-trabelsi-24b73494/");
    }


    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("demo Management API")
                .pathsToMatch("/**/**")
                .pathsToExclude("**")
                .build();
    }


}
