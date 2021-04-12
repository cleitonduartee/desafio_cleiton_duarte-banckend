package com.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.desafio.domain.Utensilio;
import com.desafio.repository.UtensilioRepository;
import com.desafio.service.exception.DataIntegrityException;
import com.desafio.service.exception.NotFoundResourceException;

@Service
public class UtensilioService {

	@Autowired
	private UtensilioRepository repo;

	public Utensilio buscarPorId(Integer id) {
		Optional<Utensilio> p1 = repo.findById(id);
		return p1.orElseThrow(()-> new NotFoundResourceException("Recurso informado não encontrado. ID: "+id));
	}
	public List<Utensilio> buscarTodos() {
		List<Utensilio> list = repo.findAll();		
		return list;
	}
	public Utensilio atualizar(Integer id, Utensilio utensilioUpdate) {
		Utensilio utensilio = buscarPorId(id);
		updateData(utensilio, utensilioUpdate);
		repo.save(utensilio);
		return utensilio;
	}
	private void updateData (Utensilio utensilio, Utensilio utensilioUpdate) {
		try {
			utensilio.setNome(utensilioUpdate.getNome());
			utensilio.setDisponivel(utensilioUpdate.getDisponivel());
			utensilio.setEstado(utensilioUpdate.getEstado());
			utensilio.setUrlImagem(utensilioUpdate.getUrlImagem());
			
		} catch (HttpMessageNotReadableException e) {
			e.printStackTrace();
		}
	}
	public void cadastrar(Utensilio newUtensilio) {
		try {
			newUtensilio.setId(null);		
			repo.save(newUtensilio);
		} catch (DataIntegrityViolationException e) {			
			throw new DataIntegrityException("Pessoa não pode ser NULL. Informe uma pessoa para salvar o Utensilio");
		}	
		
		
	}
	public void deletar(Integer id) {		
		try {
			repo.deleteById(id);	
		} catch (RuntimeException e) {
			e.printStackTrace();
		}	
	}
	public Page<Utensilio> buscarComPaginacao (Integer page, Integer size, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
