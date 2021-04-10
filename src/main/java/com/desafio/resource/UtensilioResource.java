package com.desafio.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping
	public ResponseEntity<List<Utensilio>> burcarTodos(){
		List<Utensilio> list  = service.buscarTodos();		
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Utensilio> atualizar(@PathVariable Integer id, @RequestBody Utensilio UtensilioUpdate){
		System.out.println(UtensilioUpdate.getEstado());
		UtensilioUpdate = service.atualizar(id, UtensilioUpdate);		
		return ResponseEntity.ok().body(UtensilioUpdate);
	}
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody Utensilio utensilio){
		System.out.println(utensilio.getPessoa()+"- cadastrar");
		service.cadastrar(utensilio);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(utensilio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		service.deletar(id);		
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Utensilio>> burcarComPaginacao(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			
			){
		Page<Utensilio> listPage  = service.buscarComPaginacao(page, size,direction,orderBy);		
		return ResponseEntity.ok().body(listPage);
	}
}
