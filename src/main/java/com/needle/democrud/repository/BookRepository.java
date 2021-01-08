package com.needle.democrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.needle.democrud.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
