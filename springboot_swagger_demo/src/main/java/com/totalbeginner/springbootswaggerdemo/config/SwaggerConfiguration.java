package com.totalbeginner.springbootswaggerdemo.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.totalbeginner.springbootswaggerdemo"))
				.paths(regex("/rest.*"))
				.build()
				.apiInfo(metaData());
		
	}
	
	// I am overriding the default
	
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger Demo API")
                .description("\"Spring Boot Swagger API for Training Purposes\"")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("Msizi Nkomo", "https://www.mondiamedia/about/", "msizi.nkomo@mondiamedia.com"))
                .build();
    }

}
