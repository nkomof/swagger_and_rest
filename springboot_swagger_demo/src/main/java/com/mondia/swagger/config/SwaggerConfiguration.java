package com.mondia.swagger.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    private static final String SWAGGER_API_VERSION = "1.0";

    private static final String LICENSE_TEXT = "Apache License Version 2.0";

    private static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";

    private static final String title = "Users REST API";

    private static final String description = "RESTful API for Users";
    

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(SWAGGER_API_VERSION)
                .license(LICENSE_TEXT)
                .licenseUrl(LICENSE_URL)
                .contact(new Contact("Msizi Nkomo", "https://www.mondiamedia/about/", "msizi.nkomo@mondiamedia.com"))
                .build();
    }

    @Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mondia.swagger"))
                .paths(regex("/user.*"))
                .build();
        
    }

}
