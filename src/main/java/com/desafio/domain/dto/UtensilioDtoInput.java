package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.enuns.EstadoUtensilio;

public class UtensilioDtoInput implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String nome;
	private String urlImagem;
	private Integer estado;
	private Boolean disponivel;
	private Integer pessoa_id;	
	
	public UtensilioDtoInput(String nome, String urlImagem, EstadoUtensilio estado, Boolean disponivel,Integer pessoa_id) {
		super();
		this.nome = nome;
		this.urlImagem = urlImagem;
		this.estado = estado.getCod();
		this.disponivel = disponivel;
		this.pessoa_id = pessoa_id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(Integer pessoa_id) {
		this.pessoa_id = pessoa_id;
	}
	
}
