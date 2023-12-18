package com.example.humanresourcepayment.services;

import org.springframework.stereotype.Service;

import com.example.humanresourcepayment.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPatmentPerWorker (Long id, Integer days) {
		// pagamento mocado
		return new Payment("Rafael de Luca", 300.0, days);
	}

}
