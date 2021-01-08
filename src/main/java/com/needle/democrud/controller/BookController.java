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
		try {
			return bookService.findBookById(id);
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, Message.RESOURCE_NOT_FOUND_MESSAGE, e);
		}
	}

	@PostMapping("/book")
	public @ResponseBody ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
	}

	@PutMapping("/book/{id}")
	public @ResponseBody ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Long id) {
		try {
			return new ResponseEntity<>(bookService.update(book, id), HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, Message.RESOURCE_NOT_FOUND_MESSAGE, e);
		}
	}

	@DeleteMapping("/book/{id}")
	public @ResponseBody ResponseEntity<String> deleteBook(@PathVariable Long id) {
		return new ResponseEntity<>(Message.DELETE_MESSAGE, HttpStatus.OK);
	}
}
