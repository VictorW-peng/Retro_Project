/**
 * @author William.Patrick
 * @data 2022/10/12 22:48
 */
package com.example.solution.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * web端
     *  给命名然后过滤接口。
     * @return
     */
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*"))).build();
    }

    /**
     * 后台管理端
     * @return
     */
    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("adminApi")
                .apiInfo(adminApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*"))).build();
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder().title("网站的API文档")
                .description("本文档描述了潇雷视频网的api接口定义")
                .version("1.0")
                .build();
    }
    private ApiInfo adminApiInfo(){
        return new ApiInfoBuilder().title("后台管理系统的API文档")
                .description("本文档描述了潇雷视频网的后台管理端api接口定义")
                .version("1.0")
                .build();
    }

}
