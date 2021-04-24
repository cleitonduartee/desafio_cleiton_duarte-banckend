package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.Pessoa;
import com.desafio.domain.Utensilio;
import com.desafio.domain.enuns.EstadoUtensilio;

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

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public EstadoUtensilio getEstado() {
		return EstadoUtensilio.fromEstado(estado);
	}

	public void setEstado(EstadoUtensilio estado) {
		this.estado = estado.getCod();
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
