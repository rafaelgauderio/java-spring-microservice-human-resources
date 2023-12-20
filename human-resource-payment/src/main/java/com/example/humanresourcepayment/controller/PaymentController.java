package com.example.humanresourcepayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.humanresourcepayment.entities.Payment;
import com.example.humanresourcepayment.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@HystrixCommand(fallbackMethod = "getPaymentPerWorkerPerDayWhenErrorOccurs")
	@GetMapping(value="{workerId}/days/{days}")
	public ResponseEntity<Payment> getPaymentPerWorkerPerDay (@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = paymentService.getPatmentPerWorker(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentPerWorkerPerDayWhenErrorOccurs(Long workerId, Integer days) {
		Payment payment = new Payment("Default value", 500.0, days);
		return ResponseEntity.ok(payment);
	}	

}
