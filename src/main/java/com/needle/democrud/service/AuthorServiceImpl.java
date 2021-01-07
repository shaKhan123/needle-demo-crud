package com.needle.democrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.democrud.entity.Author;
import com.needle.democrud.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author findById(long id) {
		return authorRepository.findById(id);
	}

	public Author saveAuthor(Author author) {		
		return authorRepository.save(author);
	}

	public Author updateAuthor(Author mockAuthor) {
		
		return new Author();
	}

}
