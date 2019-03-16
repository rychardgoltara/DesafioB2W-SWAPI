package com.rychardgoltara.planetsproject.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rychardgoltara.planetsproject.domain.Planet;
import com.rychardgoltara.planetsproject.domain.PlanetList;
import com.rychardgoltara.planetsproject.domain.PlanetResponse;
import com.rychardgoltara.planetsproject.services.PlanetService;



@RestController
@RequestMapping(value="/planets")
public class PlanetResource {
	
	
	@Autowired
	private PlanetService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Planet>> findAll(){
		List<Planet> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Planet> findById(@PathVariable String id){
		Planet planet = service.findById(id);
		return ResponseEntity.ok().body(planet);
	}
	@RequestMapping(value="/name/{name}", method=RequestMethod.GET)
	public ResponseEntity<Planet> findByName(@PathVariable String name){
		Planet planet = service.findByName(name);
		return ResponseEntity.ok().body(planet);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Planet planet){
		planet = validateAppears(planet);
		Planet p = service.insert(planet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody Planet planet, @PathVariable String id) {
		planet.setId(id);
		service.update(planet);
		return ResponseEntity.noContent().build();
	}
	
public HttpEntity<String> geraHeader(){
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		return entity;
	}

public Planet validateAppears(Planet planet) {
		RestTemplate restTemplate = new RestTemplate();
		List<PlanetResponse> lista = new ArrayList<PlanetResponse>();
		HttpEntity<String> header = geraHeader();
		for(int i = 1; i<8; i++) {
			lista.addAll(restTemplate.exchange("https://swapi.co/api/planets/?page="+i,HttpMethod.GET, header ,PlanetList.class).getBody().getResults());
		}
		for (PlanetResponse plan : lista) {
			if(plan.getName().contentEquals(planet.getName())) {
				planet.setApparitions(plan.getFilms().size());
				break;
			}
		}
		return planet;
}
	
}
