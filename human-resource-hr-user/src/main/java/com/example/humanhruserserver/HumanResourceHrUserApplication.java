package com.example.humanhruserserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class HumanResourceHrUserApplication implements CommandLineRunner {

	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(HumanResourceHrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//System.out.println("BCryptPasswordEncoder = " + bcryptPasswordEncoder.encode("microsservico") );
		
	}

}
