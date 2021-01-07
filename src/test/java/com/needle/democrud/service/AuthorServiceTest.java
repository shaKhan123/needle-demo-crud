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

		when(authorRepository.findById(Mockito.anyLong())).thenReturn(mockAuthor);
		Author author = authorService.findById(1L);

		assertEquals(mockAuthor.getId(), author.getId());
	}

	@Test
	void saveAuthorTest() {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorRepository.save(Mockito.any(Author.class))).thenReturn(mockAuthor);
		Author author = authorService.saveAuthor(mockAuthor);

		assertEquals(mockAuthor.getId(), author.getId());
	}

	@Test
	void updateAuthorTest() {
		Author mockAuthor = TestData.getMockAuthor();

		Author updatedMockAuthor = TestData.getMockAuthor();
		updatedMockAuthor.setFirstName("jane");

		when(authorRepository.findById(Mockito.anyLong())).thenReturn(mockAuthor);

		when(authorRepository.save(Mockito.any(Author.class))).thenReturn(updatedMockAuthor);
		Author author = authorService.updateAuthor(updatedMockAuthor, 1);

		assertEquals(updatedMockAuthor.getFirstName(), author.getFirstName());
	}

	@Test
	void deleteAuthorTest() {
		Author mockAuthor = TestData.getMockAuthor();

		authorService.deleteAuthor(mockAuthor);

		Mockito.verify(authorRepository, Mockito.times(1)).delete(Mockito.any(Author.class));
	}
}
