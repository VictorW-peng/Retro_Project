package com.example.solution.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI 3 文档配置。
 *
 * <p>替代与 Spring Boot 2.6+ 路径匹配策略不兼容的 springfox 2.x，
 * 启动后可访问 /swagger-ui.html 与 /v3/api-docs。</p>
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI sutureOpenApi(@Value("${info.app.version:1.0.0}") String version,
                                 @Value("${info.app.name:suture-server}") String name) {
        return new OpenAPI()
                .info(new Info()
                        .title(name + " API")
                        .version(version)
                        .description("Suture 后端接口文档")
                        .contact(new Contact()
                                .name("William")
                                .email("3159814788@qq.com")));
    }
}
