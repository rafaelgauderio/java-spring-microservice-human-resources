package com.rafaeldeluca.humanresourceworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// dependência actuator - atualiza as configurações em runtime (tempo de execução)

@RefreshScope
@EnableEurekaClient
@SpringBootApplication
public class HumanResourceWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceWorkerApplication.class, args);
	}

}
