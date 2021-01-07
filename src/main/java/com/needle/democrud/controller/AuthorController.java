package com.needle.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.needle.democrud.entity.Author;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@GetMapping("/author/{id}")
	Author getEmployeeById(@PathVariable Long id) {
		try {
			return authorService.findById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author Not Found for given Id", e);
		}
	}

	@PostMapping("/author")
	public @ResponseBody ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
		return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.OK);
	}
}
