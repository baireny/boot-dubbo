package com.baireny.dubbo.provider.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDubboConfig {
    @Bean
    public Docket petApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())//添加所有Controller
//               添加指定包下的Controller文件
                .apis(RequestHandlerSelectors.basePackage("com.baireny.dubbo.provider.service"))
                .paths(PathSelectors.any())
                .build();

//    Api的一些描述信息
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("测试api")
                .description("对Api的描述")
                .contact(new Contact("baireny", "https://baireny.github.io/", "baireny@sina.cn"))
                .version("v1.0")
                .build();
        docket.apiInfo(apiInfo);

        return docket;
    }
}