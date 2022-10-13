package com.example.solution;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author William.Peng
 */
@SpringBootApplication
@MapperScan("com.example.solution.dao")
@EnableSwagger2
public class SutureServerSolutionApplication {

	public static void main(String[] args) {

		SpringApplication.run(SutureServerSolutionApplication.class, args);
	}

}
