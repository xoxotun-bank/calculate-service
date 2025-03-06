package com.example.calculateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableCaching
@SpringBootApplication
public class CalculateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateServiceApplication.class, args);
	}

}
