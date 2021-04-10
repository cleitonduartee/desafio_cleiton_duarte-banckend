package com.desafio.resource;

import java.net.URI;
import java.util.List;

import javax.websocket.server.PathParam;

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
	@PostMapping
	public ResponseEntity<Void> atualizar(@RequestBody Pessoa pessoa){
		service.cadastrar(pessoa);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id){
		service.deletar(id);		
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value = "/page")
	public ResponseEntity<Page<PessoaDTO>> burcarComPaginacao(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy
			
			){
		Page<Pessoa> listPage  = service.buscarComPaginacao(page, size,direction,orderBy);
		Page<PessoaDTO> listPageDTO =  listPage.map((obj)-> new PessoaDTO(obj));
		return ResponseEntity.ok().body(listPageDTO);
	}
}
