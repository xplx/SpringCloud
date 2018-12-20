package com.example.eureka.util;

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

/**
 * @author wuxiaopeng
 * @create 2018-07-12 17:50
 * Swagger在线文档工具类
 **/
@Configuration //spring boot配置注解
@EnableSwagger2 //启用swagger2功能注解
public class Swagger2 {
    @Bean
    public Docket createRestfulApi() {//api文档实例
        return new Docket(DocumentationType.SWAGGER_2)//文档类型：DocumentationType.SWAGGER_2
                .apiInfo(apiInfo())//api信息
                .select()//构建api选择器
                .apis(RequestHandlerSelectors.basePackage("com.example.eureka"))//api选择器选择api的包（注意这里写的是包名）
                .paths(PathSelectors.any())//api选择器选择包路径下任何api显示在文档中
                .build();//创建文档
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful接口")
                .description("项目接口描述：")
                .termsOfServiceUrl("")
                .contact(new Contact("wuxiaopeng","xplx12@163.com","xplx12@163.com"))
                .version("1.0")
                .build();
    }
//    private ApiInfo apiInfo() {//接口的相关信息
//        return new ApiInfoBuilder()
//                .title("Spring Boot中使用Swagger2构建RESTful接口")
//                .description("项目接口描述：")
//                .termsOfServiceUrl("termsOfServiceUrl")
//                .version("1.0.0")
//                .license("http://springfox.github.io/springfox/docs/current/")
//                .licenseUrl("http://springfox.github.io/springfox/docs/current/")
//                .build();//创建文档
//    }
}