package com.example.bootcampSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * Configuracion Swagger para la generacion de decoumentacion de la API REST
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiDetails())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any()).build();

    }
    private ApiInfo apiDetails(){
        return new ApiInfo("ApiRest Book", "Library ApiRest", "1.0", "http://www.google.com", new Contact("Juan",
                "http://www.google.com",
                "Juan123@gmail.com"), "MIT", "http://www.google.com", Collections.EMPTY_LIST);
}

}
