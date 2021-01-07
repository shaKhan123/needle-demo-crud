package com.needle.democrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.needle.democrud.repository.AuthorRepository;

@SpringBootApplication
public class DemoCrudApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
