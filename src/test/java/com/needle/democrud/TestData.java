package com.needle.democrud;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.needle.democrud.entity.Author;
import com.needle.democrud.entity.Book;

public class TestData {

	public static String URL = "/author/1";
	
	public static Author getMockAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setFirstName("john");
		author.setLastName("doe");
		author.setCountry("us");
		author.setBooks(List.of(getMockBook()));
		return author;
	}
	
	public static Book getMockBook() {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("new era");
		return book;
	}
	
	public static String getAuthorByIdJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(getMockAuthor());
	}
}
