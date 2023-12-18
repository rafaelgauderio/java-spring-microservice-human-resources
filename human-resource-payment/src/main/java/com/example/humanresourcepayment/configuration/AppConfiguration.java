package com.example.humanresourcepayment.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
	
	// criando component a partir da chamada de um método
	@Bean
	public RestTemplate registerRestTemplate () {
		
		return new RestTemplate();			
		
	}

}