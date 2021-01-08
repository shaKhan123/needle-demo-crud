package com.needle.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.needle.democrud.entity.Book;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.service.BookService;
import com.needle.democrud.util.Message;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;

	@GetMapping("/book/{id}")
	Book getBookById(@PathVariable Long id) {
		return null;
	}

	@PostMapping("/book")
	public @ResponseBody ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return null;
	}

	@PutMapping("/book/{id}")
	public @ResponseBody ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
		return null;
	}

	@DeleteMapping("/book/{id}")
	public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Long id) {
		return null;
	}
}
