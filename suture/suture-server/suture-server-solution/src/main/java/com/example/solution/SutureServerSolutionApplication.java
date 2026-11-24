package com.example.solution;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Suture 应用启动入口。
 *
 * @author William.Peng
 */
@SpringBootApplication
@ConfigurationPropertiesScan
@MapperScan("com.example.solution.dao")
public class SutureServerSolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SutureServerSolutionApplication.class, args);
    }
}
