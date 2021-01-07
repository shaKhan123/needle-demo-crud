package com.needle.democrud.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.needle.democrud.TestData;
import com.needle.democrud.entity.Author;


public class AuthorServiceTest {
   
	@InjectMocks
    AuthorService authorService;
     
    @Mock
    AuthorRepository authorRepository;
    
	@Test
	void findAuthorByIdTest() {
		Author mockAuthor = TestData.getMockAuthor();
		
		when(authorRepository.findById(Mockito.anyString()))
		.thenReturn(mockAuthor);
		Author author = authorService.findById("1");
		
		assertEquals(mockAuthor.getId(), author.getId());
	}
	

}
