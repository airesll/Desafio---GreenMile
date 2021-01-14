package com.br.gm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.gm.model.Stop;

public interface StopRepository extends MongoRepository<Stop, String>{
	public Stop findByDescription(String description);
}
