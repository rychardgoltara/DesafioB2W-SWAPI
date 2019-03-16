package com.rychardgoltara.planetsproject.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(collection="planet")
public class Planet implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Id
	String id;
	
	String name;
	
	String terrain;
	
	String climate;
	
	int apparitions;
	
	
	public Planet() {
	}
	
	public Planet(String name, String terrain, String climate) {
		super();
		this.name = name;
		this.terrain = terrain;
		this.climate = climate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public int getApparitions() {
		return apparitions;
	}
	public void setApparitions(int apparitions) {
		this.apparitions = apparitions;
	}
}
