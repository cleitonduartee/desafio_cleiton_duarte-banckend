package com.desafio.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Pessoa;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@GetMapping
	public ResponseEntity<Pessoa> burcar(){
		Pessoa p1 = new Pessoa(null, "Cleiton", "67 99999-9999");
		return ResponseEntity.ok().body(p1);
	}
}
