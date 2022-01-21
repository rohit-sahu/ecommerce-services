/*
package com.zipcar.orderservice.config;

import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

*/
/**
 * The Class SwaggerConfig.
 *//*

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@SwaggerDefinition(
        consumes = {MediaType.APPLICATION_JSON_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        securityDefinition = @SecurityDefinition(apiKeyAuthDefintions = {
                @ApiKeyAuthDefinition(key = "ORDER-SERVICE-API-VERSION", name = "Api Version for each api", description = "Version of api need to be sent",
                        in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER)
                @ApiKeyAuthDefinition(key = "Authorization", name = "Authorization token", description = "Auth token need to be sent in each api",
                        in = ApiKeyAuthDefinition.ApiKeyLocation.HEADER)
        })
)
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zipcar.orderservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title(
                        "Order Service Application")
                .description("REST API Documentation")
                .version("1.0")
                .termsOfServiceUrl("Terms of service")
                .contact(new Contact("Rohit Kumar", "", "rohitraj.r@hotmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
*/
