package com.needle.democrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.needle.democrud.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findById(long id);
	void deleteById(long id);
}