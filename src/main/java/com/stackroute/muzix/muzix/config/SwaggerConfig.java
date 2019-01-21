package com.stackroute.muzix.muzix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.stackroute.muzix.muzix"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(metaInfo());

    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo;
        apiInfo = new ApiInfo("Spring Boot Swagger",
                "Swagger Documentation For Muzix application",
                "2.0",
                "Terms of service",
                new Contact("Muzix", "https://github.com/bharath", "bharas21@gmail.com"),
                "Apache version 2.0",
                "https://www.apache.org/licensen.html");
        return apiInfo;
    }
}

