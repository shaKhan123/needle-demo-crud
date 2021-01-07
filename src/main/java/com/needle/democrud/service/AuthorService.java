package com.needle.democrud.service;

import com.needle.democrud.entity.Author;
import com.needle.democrud.error.ResourceNotFoundException;

public interface AuthorService {

	public Author findById(Long id) throws ResourceNotFoundException;
	public Author saveAuthor(Author author);
	public Author updateAuthor(Author updatedAuthor, Long id) throws ResourceNotFoundException;
	public void deleteAuthor(Author author);
}
