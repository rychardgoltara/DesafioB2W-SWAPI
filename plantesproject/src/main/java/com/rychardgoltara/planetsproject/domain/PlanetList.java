package com.rychardgoltara.planetsproject.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetList {


	 private List<PlanetResponse> results;
	 
	 public PlanetList() {
		}
	 
	 public PlanetList(List<PlanetResponse> results, String name) {
			this.results = results;
		}
	 
	public List<PlanetResponse> getResults() {
		return results;
	}
	public void setResults(List<PlanetResponse> results) {
		this.results = results;
	}
	
	
}
