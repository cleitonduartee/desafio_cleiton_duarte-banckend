package com.desafio.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.desafio.domain.enuns.EstadoUtensilio;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Utensilio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String urlImagem;
	private Integer estado;
	private Boolean disponivel;
	
	@ManyToOne()
	@JoinColumn(name = "pessoa_id", nullable = false)	
	private Pessoa pessoa;
	
	public Utensilio(Integer id, String nome, String urlImagem, EstadoUtensilio estado, Boolean disponivel,Pessoa pessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.urlImagem = urlImagem;
		this.estado = estado==null ? null : estado.getCod();
		this.disponivel = disponivel;
		this.pessoa = pessoa;
	}	

	public EstadoUtensilio getEstado() {
		return EstadoUtensilio.fromEstado(estado);
	}

	public void setEstado(EstadoUtensilio estado) {
		this.estado = estado.getCod();
	}	

}
