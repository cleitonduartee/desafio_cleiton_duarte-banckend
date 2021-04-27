package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.Utensilio;
import com.desafio.domain.enuns.EstadoUtensilio;

import lombok.Data;

@Data
public class UtensilioDtoOutputList implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String urlImagem;
	private Integer estado;
	private Boolean disponivel;
	
		
	public UtensilioDtoOutputList(Utensilio obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		urlImagem = obj.getUrlImagem();
		estado = obj.getEstado().getCod();
		disponivel = obj.getDisponivel();		
	}
	

	public EstadoUtensilio getEstado() {
		return EstadoUtensilio.fromEstado(estado);
	}

	public void setEstado(EstadoUtensilio estado) {
		this.estado = estado.getCod();
	}

		
	
}
