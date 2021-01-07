package com.needle.democrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.democrud.entity.Author;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author findById(Long id) throws ResourceNotFoundException {
		return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author updateAuthor(Author updatedAuthor, Long id) throws ResourceNotFoundException {

		return authorRepository.findById(id).map(author -> {
			author.setId(updatedAuthor.getId());
			author.setFirstName(updatedAuthor.getFirstName());
			author.setLastName(updatedAuthor.getLastName());
			author.setCountry(updatedAuthor.getCountry());
			author.setBooks(updatedAuthor.getBooks());
			return authorRepository.save(author);
		})
		.orElseThrow(() -> new ResourceNotFoundException());

	}

	@Override
	public void deleteAuthor(Author author) {
		authorRepository.delete(author);
	}

}
