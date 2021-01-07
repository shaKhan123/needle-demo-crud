package com.needle.democrud.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.needle.democrud.TestData;
import com.needle.democrud.entity.Author;
import com.needle.democrud.repository.AuthorRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AuthorServiceTest {
   
	@InjectMocks
	AuthorServiceImpl authorService;
     
    @Mock
    AuthorRepository authorRepository;
    
	@Test
	void findAuthorByIdTest() {
		Author mockAuthor = TestData.getMockAuthor();
		
		when(authorRepository.findById(Mockito.anyLong()))
		.thenReturn(mockAuthor);
		Author author = authorService.findById(1L);
		
		assertEquals(mockAuthor.getId(), author.getId());
	}
	

}
