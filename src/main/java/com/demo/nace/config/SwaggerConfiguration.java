package com.demo.nace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class contains methods for swagger
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * This method prepares bean for swagger ui
     * @return
     */
    @Bean
    public Docket naceDetailsApi(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.demo.nace.controller")).build();
    }
}
