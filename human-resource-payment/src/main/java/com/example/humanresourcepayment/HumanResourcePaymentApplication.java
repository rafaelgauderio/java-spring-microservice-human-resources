package com.example.humanresourcepayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HumanResourcePaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourcePaymentApplication.class, args);
	}

}
