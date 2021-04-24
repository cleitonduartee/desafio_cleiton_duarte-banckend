package com.desafio.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.domain.Pessoa;
import com.desafio.domain.dto.PessoaDtoInput;
import com.desafio.domain.dto.PessoaDtoOutput;
import com.desafio.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDtoOutput> burcarPorId(@PathVariable Integer id){
		Pessoa pessoa = service.buscarPorId(id);
		PessoaDtoOutput pessoaDtoOutput = new PessoaDtoOutput(pessoa);
		return ResponseEntity.ok().body(pessoaDtoOutput);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDtoOutput>> burcarTodos(){
		List<PessoaDtoOutput> list  = service.buscarTodos();		
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(list);
	}	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDtoOutput> atualizar(@PathVariable Integer id, @RequestBody PessoaDtoInput PessoaUpdate){
		Pessoa pessoa = service.atualizar(id, PessoaUpdate);
		PessoaDtoOutput pessoaDtoOutput = new PessoaDtoOutput(pessoa);
		return ResponseEntity.ok().body(pessoaDtoOutput);
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> atualizar(@RequestBody PessoaDtoInput newPessoa){
		Pessoa pessoa = service.cadastrar(newPessoa);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		service.deletar(id);		
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value = "/page")
	public ResponseEntity<Page<PessoaDtoOutput>> burcarComPaginacao(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			
			){
		Page<Pessoa> listPage  = service.buscarComPaginacao(page, size,direction,orderBy);
		Page<PessoaDtoOutput> listPageDTO =  listPage.map((obj)-> new PessoaDtoOutput(obj));
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(listPageDTO);
	}
}
