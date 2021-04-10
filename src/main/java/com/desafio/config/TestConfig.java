package com.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.domain.Pessoa;
import com.desafio.domain.Utensilio;
import com.desafio.domain.enuns.EstadoUtensilio;
import com.desafio.repository.PessoaRepository;
import com.desafio.repository.UtensilioRepository;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepo;
	
	@Autowired
	private UtensilioRepository UtensilioRepo;
	
	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null, "João da Esquina", "6799999999");
		Pessoa p2 = new Pessoa(null, "Maria do Bairro", "65988888888");
		Pessoa p3 = new Pessoa(null, "Pedro de Jesus", "67997777777");
		Pessoa p4 = new Pessoa(null, "José Augusto", "679789456123");
		
		
		Utensilio u1 = new Utensilio(null, "Mesa de Cozinha", "", EstadoUtensilio.USADO, true,p2);
		Utensilio u2 = new Utensilio(null, "Sofá", "", EstadoUtensilio.USADO, true,p3);
		Utensilio u3 = new Utensilio(null, "Cadeira de Plastico", "", EstadoUtensilio.NOVO, true,p1);
		
		p1.AddUtensilio(u3);
		p2.AddUtensilio(u1);
		p3.AddUtensilio(u2);
		
		
		pessoaRepo.saveAll(Arrays.asList(p1,p2,p3,p4));
		UtensilioRepo.saveAll(Arrays.asList(u1,u2,u3));
		
	}

}
