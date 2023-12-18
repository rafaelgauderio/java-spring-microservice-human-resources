package com.example.humanresourcepayment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.humanresourcepayment.WorkerFeignClient;
import com.example.humanresourcepayment.entities.Payment;
import com.example.humanresourcepayment.entities.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPatmentPerWorker(Long workerId, Integer days) {

		// dicionário de parametros com chave e valor da interface Map
		// Map<String, String> uriParameters = new HashMap<String, String>();
		// uriParameters.put("id", String.valueOf(workerId));
		// Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}",
		// Worker.class, uriParameters);
		Worker worker = workerFeignClient.findWorkerById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
