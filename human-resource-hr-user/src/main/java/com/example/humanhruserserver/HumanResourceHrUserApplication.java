package com.example.humanhruserserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HumanResourceHrUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceHrUserApplication.class, args);
	}

}
