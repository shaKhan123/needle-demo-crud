package com.needle.democrud.service;

import com.needle.democrud.entity.Book;
import com.needle.democrud.error.ResourceNotFoundException;

public interface BookService {

	public Book findBookById(Long id) throws ResourceNotFoundException;

	public Book save(Book book);

	public void delete(Long id);

	Book update(Book book, Long id) throws ResourceNotFoundException;;
}
