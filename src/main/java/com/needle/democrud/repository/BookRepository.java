package com.needle.democrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.needle.democrud.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
