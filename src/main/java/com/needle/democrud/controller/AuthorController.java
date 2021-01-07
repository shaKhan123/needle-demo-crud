package com.needle.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.needle.democrud.entity.Author;
import com.needle.democrud.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@GetMapping("/author/{id}")
	Author getEmployeeById(@PathVariable Long id) {
		return null;
		
	}
}
