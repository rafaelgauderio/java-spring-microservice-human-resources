package com.rafaeldeluca.humanresourceworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaeldeluca.humanresourceworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
