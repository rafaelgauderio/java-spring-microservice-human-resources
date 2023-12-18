package com.rafaeldeluca.humanresourceworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaeldeluca.humanresourceworker.entities.Worker;
import com.rafaeldeluca.humanresourceworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAllWorkers () {
		List<Worker> workerList = workerRepository.findAll();
		return ResponseEntity.ok(workerList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findWorkerById(@PathVariable Long id) {
		
		logger.info("LOCAL SERVER PORT: " + environment.getProperty("local.server.port"));
		
		Worker workerOptional = workerRepository.findById(id).get();
		return ResponseEntity.ok(workerOptional);
	}
	
	
	

}
