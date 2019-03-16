package com.rychardgoltara.planetsproject.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rychardgoltara.planetsproject.domain.Planet;
import com.rychardgoltara.planetsproject.domain.PlanetList;
import com.rychardgoltara.planetsproject.domain.PlanetResponse;
import com.rychardgoltara.planetsproject.repository.PlanetRepository;
import com.rychardgoltara.planetsproject.services.exception.ObjectNotFoundException;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetRepository repo;
	
	public List<Planet> findAll(){
		return repo.findAll();
	}
	
	public Planet findById(String id) {
		Optional<Planet> planet = repo.findById(id);
		if(!planet.isPresent()) {
			throw new ObjectNotFoundException("Objeto Não Encontrado");
		}
		return planet.get();
	}
	
	public Planet insert(Planet planet) {		
		return repo.insert(planet);
	}
	
	public Planet findByName(String name) {
		 Planet planet = repo.findByName(name);
		 if(planet == null) {
				throw new ObjectNotFoundException("Objeto Não Encontrado");
		 }
		 return planet;
	}
	
	public void delete(String id) {
		Planet p = findById(id);
		repo.delete(p);
	}
		
	public Planet update(Planet planetNew) {
		Planet planetOld = findById(planetNew.getId());
		updateData(planetOld, planetNew);
		return repo.save(planetOld);
	}
	
	private void updateData(Planet oldPlanet, Planet newPlanet) {
		oldPlanet.setName(newPlanet.getName());
		oldPlanet.setTerrain(newPlanet.getTerrain());
		oldPlanet.setClimate(newPlanet.getClimate());
	}
}
