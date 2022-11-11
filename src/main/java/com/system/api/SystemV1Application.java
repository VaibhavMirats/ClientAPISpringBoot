package com.system.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SystemV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SystemV1Application.class, args);
	}
}
