package com.example.humanresourceapigateway.com.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

// gatewall zuul vai rotear as requisiçõe a partir dos nomes dos microsserviços

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class HumanResourceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceApiGatewayApplication.class, args);
	}

}
