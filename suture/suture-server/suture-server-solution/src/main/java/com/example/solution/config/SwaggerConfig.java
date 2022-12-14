/**
 * @author William.Patrick
 * @data 2022/10/12 22:48
 */
package com.example.solution.config;

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
public class SwaggerConfig {
    /**
     * @Description:swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("serverAPI")
                .apiInfo(apiInfo())
                .select()
                // 配置到项目的controller包
                .apis(RequestHandlerSelectors.basePackage("com.example.solution.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * @Description: 构建api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Extremely suture system")
                .description("This is a study project, it assembles many function")
                .contact(new Contact("william", "xxx.com网站", "3159814788@qq.com"))
                // 定义版本号
                .version("版本号:0.0.1").build();
    }

}
