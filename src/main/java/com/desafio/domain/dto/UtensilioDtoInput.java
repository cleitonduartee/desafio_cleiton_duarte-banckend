package com.desafio.domain.dto;

import java.io.Serializable;

import com.desafio.domain.enuns.EstadoUtensilio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UtensilioDtoInput implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String nome;
	private String urlImagem;
	private Integer estado;
	private Boolean disponivel;
	private Integer pessoa_id;	

	public EstadoUtensilio getEstado() {
		return EstadoUtensilio.fromEstado(estado);
	}

	public void setEstado(EstadoUtensilio estado) {
		this.estado = estado.getCod();
	}

}
