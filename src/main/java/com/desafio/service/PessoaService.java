package com.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Pessoa;
import com.desafio.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;

	public Pessoa buscarPorId(Integer id) {
		Optional<Pessoa> p1 = repo.findById(id);
		return p1.get();
	}
}
