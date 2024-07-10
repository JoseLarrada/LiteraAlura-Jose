package com.challengueAlura.literaula;

import com.challengueAlura.literaula.principal.Principal;
import com.challengueAlura.literaula.repository.AutorRepository;
import com.challengueAlura.literaula.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraulaApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository repositorio;
	@Autowired
	private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal=new Principal(repositorio,autorRepository);
		principal.principal();
	}
}
