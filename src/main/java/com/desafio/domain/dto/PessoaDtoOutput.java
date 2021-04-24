package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.Pessoa;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
