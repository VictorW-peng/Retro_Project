package com.example.solution;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.solution.dao")
public class SutureServerSolutionApplication {

	public static void main(String[] args) {

		SpringApplication.run(SutureServerSolutionApplication.class, args);
	}

}
