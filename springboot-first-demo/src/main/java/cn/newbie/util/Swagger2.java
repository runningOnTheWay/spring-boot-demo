package cn.newbie.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
//  @Value("${swagger.regex}")
//  private String regex;
  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(apiInfo())
      .select()
      .apis(RequestHandlerSelectors.basePackage("cn.newbie.api"))//使用多个controller的共同拥有的父类，即精确到两个controller的上一级
      //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))--所有的controller类
      .paths(PathSelectors.any())
      .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Spring Boot中使用Swagger2构建RESTful APIs")
      .description("测试")
      .contact("程序猿")
      .version("1.0")
      .build();
  }
}
