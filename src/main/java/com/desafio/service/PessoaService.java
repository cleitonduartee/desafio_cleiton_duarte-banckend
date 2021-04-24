package com.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.desafio.domain.Pessoa;
import com.desafio.domain.dto.PessoaDtoInput;
import com.desafio.domain.dto.PessoaDtoOutput;
import com.desafio.repository.PessoaRepository;
import com.desafio.service.exception.DataIntegrityException;
import com.desafio.service.exception.NotFoundResourceException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa buscarPorId(Integer id) {		
		Optional<Pessoa> p1 = repo.findById(id);
		return p1.orElseThrow(()-> new NotFoundResourceException("Recurso informado não encontrado. ID: "+id));
	}
	
	public List<PessoaDtoOutput> buscarTodos() {
		List<Pessoa> list = repo.findAll();	
		List<PessoaDtoOutput>listDTO = list.stream().map((obj)-> new PessoaDtoOutput(obj)).collect(Collectors.toList());
		return listDTO;
	}
	public Pessoa atualizar(Integer id, PessoaDtoInput objUpdade) {
		Pessoa pessoa = buscarPorId(id);
		updateData(pessoa, objUpdade);
		repo.save(pessoa);
		return pessoa;
	}
	private void updateData (Pessoa pessoa, PessoaDtoInput objUpdade) {
		try {
			pessoa.setNome(objUpdade.getNome());
			pessoa.setTelefone(objUpdade.getTelefone());
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	public Pessoa cadastrar(PessoaDtoInput newPessoa) {			
		Pessoa pessoa = new Pessoa(null,newPessoa.getNome(), newPessoa.getTelefone());
		repo.save(pessoa);
		return pessoa;
	}
	public void deletar(Integer id) {		
		try {
			repo.deleteById(id);	
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir a pessoa pois existe utensilios vinculado.");
		}	
	}
	public Page<Pessoa> buscarComPaginacao (Integer page, Integer size, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
