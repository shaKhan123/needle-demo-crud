package com.needle.democrud.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.needle.democrud.TestData;
import com.needle.democrud.entity.Book;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.repository.BookRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookServiceTest {

	@InjectMocks
	BookService bookService;
	
	@Mock
	BookRepository bookRepository;
	
	@Test
	void findAuthorByIdTest() throws ResourceNotFoundException {
		Book mockBook = TestData.getMockBook();

		when(bookRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(mockBook));
		Book book = bookService.findBookById(1L);

		assertEquals(mockBook.getId(), book.getId());
	}

	@Test
	void saveAuthorTest() {
		Book mockBook = TestData.getMockBook();

		when(bookRepository.save(Mockito.any(Book.class))).thenReturn(mockBook);
		Book book = bookService.save(mockBook);

		assertEquals(mockBook.getId(), book.getId());
	}

	@Test
	void updateAuthorTest() throws ResourceNotFoundException {
		Book mockBook = TestData.getMockBook();
		Book updatedMockBook = TestData.getMockBook();
		updatedMockBook.setTitle("new era 2");

		when(bookRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.of(mockBook));
		when(bookRepository.save(Mockito.any(Book.class))).thenReturn(updatedMockBook);
		
		Book book = bookService.update(updatedMockBook, 1L);

		assertEquals(updatedMockBook.getTitle(), book.getTitle());
	}

	@Test
	void deleteAuthorTest() {
		bookService.delete(1L);
		Mockito.verify(bookRepository, Mockito.times(1)).deleteById(Mockito.any(Long.class));
	}

	@Test
	void testExpectedExceptionResourceNotFoundException() {
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			bookService.findBookById(1L);
		});
	}
	
}
