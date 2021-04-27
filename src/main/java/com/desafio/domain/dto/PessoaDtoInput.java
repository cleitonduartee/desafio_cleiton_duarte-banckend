package com.desafio.domain.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PessoaDtoInput implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;	
	private String nome;
	private String telefone;
	
	public PessoaDtoInput (String nome, String telefone) {		
		this.nome = nome;
		this.telefone = telefone;
	}

}
