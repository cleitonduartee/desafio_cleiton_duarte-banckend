package com.desafio.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Pessoa;
import com.desafio.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> burcarPorId(@PathVariable Integer id){
		Pessoa p1 = service.buscarPorId(id);
		return ResponseEntity.ok().body(p1);
	}
}
