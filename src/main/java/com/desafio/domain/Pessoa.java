package com.desafio.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Utensilio> utensilios = new ArrayList<>();

	public Pessoa(Integer id, String nome, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}

	@JsonIgnore
	public List<Utensilio> getUtensilios() {
		return utensilios;
	}

	public void AddUtensilio(Utensilio utensilio) {
		utensilios.add(utensilio);
	}
}
