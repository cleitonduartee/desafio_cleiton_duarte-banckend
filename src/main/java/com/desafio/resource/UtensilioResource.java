package com.desafio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Utensilio;
import com.desafio.service.UtensilioService;

@RestController
@RequestMapping("/utensilios")
public class UtensilioResource {
	
	@Autowired
	private UtensilioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Utensilio> burcarPorId(@PathVariable Integer id){
		Utensilio p1 = service.buscarPorId(id);
		return ResponseEntity.ok().body(p1);
	}
}
