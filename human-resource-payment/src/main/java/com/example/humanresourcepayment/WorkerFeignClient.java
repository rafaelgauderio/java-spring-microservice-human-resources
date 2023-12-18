package com.example.humanresourcepayment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.humanresourcepayment.entities.Worker;

@Component
@FeignClient(name="hr-worker", path="/workers")
public interface WorkerFeignClient {
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Worker> findWorkerById(@PathVariable Long id);	
}
