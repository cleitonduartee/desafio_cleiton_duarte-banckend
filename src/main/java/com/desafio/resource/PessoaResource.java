package com.desafio.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Pessoa;
import com.desafio.domain.dto.PessoaDTO;
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
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> burcarTodos(){
		List<PessoaDTO> list  = service.buscarTodos();		
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> atualizar(@PathVariable Integer id, @RequestBody Pessoa PessoaUpdate){
		PessoaUpdate = service.atualizar(id, PessoaUpdate);
		PessoaDTO pessoaDTO = new PessoaDTO(PessoaUpdate);
		return ResponseEntity.ok().body(pessoaDTO);
	}
}
