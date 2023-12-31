package com.example.humanhruserserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.humanhruserserver.entities.User;
import com.example.humanhruserserver.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userRepository.findById(id).get();
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(value = "/find")
	public ResponseEntity<User> findByEmail(@RequestParam String email) {
		User user = userRepository.findByEmail(email);
		return ResponseEntity.ok(user);
	}
	
	

}
