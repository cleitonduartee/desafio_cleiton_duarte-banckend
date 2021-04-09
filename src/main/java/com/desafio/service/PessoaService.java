package com.desafio.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Pessoa;
import com.desafio.domain.dto.PessoaDTO;
import com.desafio.repository.PessoaRepository;
import com.desafio.service.exception.NotFoundResourceException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa buscarPorId(Integer id) {
		Optional<Pessoa> p1 = repo.findById(id);
		return p1.orElseThrow(()-> new NotFoundResourceException("Recurso informado não encontrado. ID: "+id));
	}
	
	public List<PessoaDTO> buscarTodos() {
		List<Pessoa> list = repo.findAll();	
		List<PessoaDTO>listDTO = list.stream().map((obj)-> new PessoaDTO(obj)).collect(Collectors.toList());
		return listDTO;
	}
}
