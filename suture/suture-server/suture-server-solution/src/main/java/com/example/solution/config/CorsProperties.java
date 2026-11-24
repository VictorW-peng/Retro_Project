package com.example.solution.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 跨域配置，可通过 application.yml 的 app.cors 前缀覆盖。
 */
@Data
@ConfigurationProperties(prefix = "app.cors")
public class CorsProperties {

    /** 允许的来源模式，支持通配符，例如 https://*.example.com */
    private List<String> allowedOriginPatterns = new ArrayList<>(List.of("*"));

    private List<String> allowedMethods =
            new ArrayList<>(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "OPTIONS"));

    private List<String> allowedHeaders = new ArrayList<>(List.of("*"));

    private List<String> exposedHeaders = new ArrayList<>(List.of("X-Trace-Id"));

    private boolean allowCredentials = true;

    private long maxAge = 3600L;
}
