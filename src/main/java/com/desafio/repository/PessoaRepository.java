package com.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
