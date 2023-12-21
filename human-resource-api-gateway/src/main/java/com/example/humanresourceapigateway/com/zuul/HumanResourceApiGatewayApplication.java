package com.example.humanresourceapigateway.com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// gatewall zuul vai rotear as requisiçõe a partir dos nomes dos microsserviços

@SpringBootApplication
public class HumanResourceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceApiGatewayApplication.class, args);
	}

}
