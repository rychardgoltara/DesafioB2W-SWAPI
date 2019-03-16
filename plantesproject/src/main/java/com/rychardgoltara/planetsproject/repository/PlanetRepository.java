package com.rychardgoltara.planetsproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rychardgoltara.planetsproject.domain.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	Planet findByName(String name);

}
