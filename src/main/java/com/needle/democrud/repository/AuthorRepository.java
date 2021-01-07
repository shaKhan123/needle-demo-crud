package com.needle.democrud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.needle.democrud.entity.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	Author findById(long id);
	
}