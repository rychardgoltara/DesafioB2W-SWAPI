package com.rychardgoltara.planetsproject.domain;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetResponse {

	private String name;

	private List<String> films;

		
	public PlanetResponse() {

	}

	public PlanetResponse(String name, List<String> films) {
		this.name = name;
		this.films = films;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	
	
	
	
	
}