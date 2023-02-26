package com.prototype.sejong.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// http://localhost:8080/swagger-ui/index.html
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .useDefaultResponseMessages(false)      // 기본 셋팅값인 200, 401, 402, 403, 404를 사용하지 않는다.
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.prototype.sejong.controller"))
                .paths(PathSelectors.any())     // controller package 전부
                // .paths(PathSelectors.ant("/v1/**"))  //controller package 내 v1만 택해서 할 수도 있다.
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("User Rest API Documentation")
                .description("User Rest API")
                .version("1")
                .build();
    }
}
