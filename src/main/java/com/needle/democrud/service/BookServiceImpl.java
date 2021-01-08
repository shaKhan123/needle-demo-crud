package com.needle.democrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.needle.democrud.entity.Book;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book findBookById(Long id) throws ResourceNotFoundException {
		return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book update(Book updatedBook, Long id) throws ResourceNotFoundException {
		return bookRepository.findById(id).map(book -> {
			book.setTitle(updatedBook.getTitle());
			book.setAuthor(updatedBook.getAuthor());
			return book;
		})
		.orElseThrow(() -> new ResourceNotFoundException());
	}

	@Override
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}

}
