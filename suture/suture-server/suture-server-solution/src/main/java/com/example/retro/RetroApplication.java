package com.example.retro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class RetroApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetroApplication.class, args);
    }

}
