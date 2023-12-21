package com.example.humanhrconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HumanResourceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceConfigServerApplication.class, args);
	}

}
