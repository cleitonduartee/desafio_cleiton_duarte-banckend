package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.Pessoa;
import com.desafio.domain.Utensilio;

import lombok.Data;

@Data
public class UtensilioDtoOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String urlImagem;
	private Integer estado;
	private Boolean disponivel;
	private Pessoa pessoa;
	
		
	public UtensilioDtoOutput(Utensilio obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		urlImagem = obj.getUrlImagem();
		estado = obj.getEstado().getCod();
		disponivel = obj.getDisponivel();
		pessoa = obj.getPessoa();
	}

}
