package com.desafio.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Pessoa;
import com.desafio.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository repo;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> burcarPorId(@PathVariable Integer id){
		Optional<Pessoa> p1 = repo.findById(id);
		return ResponseEntity.ok().body(p1.get());
	}
}
