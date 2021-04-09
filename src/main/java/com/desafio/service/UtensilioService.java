package com.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Utensilio;
import com.desafio.repository.UtensilioRepository;
import com.desafio.service.exception.NotFoundResourceException;

@Service
public class UtensilioService {

	@Autowired
	private UtensilioRepository repo;

	public Utensilio buscarPorId(Integer id) {
		Optional<Utensilio> p1 = repo.findById(id);
		return p1.orElseThrow(()-> new NotFoundResourceException("Recurso informado não encontrado. ID: "+id));
	}
}
