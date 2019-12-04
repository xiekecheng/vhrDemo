package com.xiekc.vhr.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 配置Swagger2
 * @author: Kecheng Xie
 * @since: 2019-11-19 23:38
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiekc.vhr.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                .description("微人事接口测试文档")
                .contact(new Contact("谢克成","xiekecheng.github.io","kc.xie@foxmail.com"))
                        .version("v1.0")
                .title("API测试文档")
                .license("Apache2.0")
                .licenseUrl("http://www . apache.org/licenses/LICENSE-2.0")
                .build());

    }
}
