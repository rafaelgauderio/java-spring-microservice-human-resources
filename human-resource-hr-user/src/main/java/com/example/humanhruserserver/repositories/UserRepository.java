package com.example.humanhruserserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.humanhruserserver.entities.User;

public interface UserRepository extends JpaRepository <User, Long>{
	
	User findByEmail(String email);

}
