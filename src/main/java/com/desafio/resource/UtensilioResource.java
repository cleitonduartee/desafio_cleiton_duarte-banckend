package com.desafio.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.desafio.domain.Utensilio;
import com.desafio.domain.dto.UtensilioDtoInput;
import com.desafio.domain.dto.UtensilioDtoOutput;
import com.desafio.domain.dto.UtensilioDtoOutputList;
import com.desafio.service.UtensilioService;

@RestController
@RequestMapping("/utensilios")
public class UtensilioResource {
	
	@Autowired
	private UtensilioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UtensilioDtoOutput> burcarPorId(@PathVariable Integer id){
		Utensilio utensilio = service.buscarPorId(id);
		UtensilioDtoOutput utensilioDtoOutput = new UtensilioDtoOutput(utensilio);
		return ResponseEntity.ok().body(utensilioDtoOutput);
	}
	
	@GetMapping
	public ResponseEntity<List<UtensilioDtoOutputList>> burcarTodos(){
		List<Utensilio> list  = service.buscarTodos();	
		List<UtensilioDtoOutputList> listDto = list.stream().map(x -> new UtensilioDtoOutputList(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").body(listDto);
	}
	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<UtensilioDtoOutput> atualizar(@PathVariable Integer id, @RequestBody UtensilioDtoInput utensilioUpdate){
		Utensilio utensilio = service.atualizar(id, utensilioUpdate);
		UtensilioDtoOutput utensilioDtoOutput = new UtensilioDtoOutput(utensilio);
		return ResponseEntity.ok().body(utensilioDtoOutput);
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> cadastrar(@RequestBody UtensilioDtoInput newUtensilio){
		Utensilio utensilio = service.cadastrar(newUtensilio);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(utensilio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@CrossOrigin
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
