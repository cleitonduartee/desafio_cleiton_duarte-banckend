package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.Pessoa;

import lombok.Data;

@Data
public class PessoaDtoOutput implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;	
	private String nome;
	private String telefone;
	
	public PessoaDtoOutput (Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		telefone = obj.getTelefone();
	}

}
