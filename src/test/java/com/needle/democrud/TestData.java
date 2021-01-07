package com.needle.democrud;

import com.needle.democrud.entity.Author;

public class TestData {

	public static Author getMockAuthor() {
		Author author = new Author();
		author.setId(1);
		author.setFirstName("john");
		author.setLastName("doe");
		author.setCountry("us");
		return author;
	}
}
