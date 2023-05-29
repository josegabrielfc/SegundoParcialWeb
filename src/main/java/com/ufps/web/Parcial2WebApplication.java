package com.ufps.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ufps.web.repository.SeleccionRepository;

@SpringBootApplication
public class Parcial2WebApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Parcial2WebApplication.class, args);
		System.out.println("Compila");
	}
	@Autowired
	private SeleccionRepository repository;
	@Override
	public void run(String... args) throws Exception {
		
	}
}
