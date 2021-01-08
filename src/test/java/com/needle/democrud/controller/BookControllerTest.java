package com.needle.democrud.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.needle.democrud.TestData;
import com.needle.democrud.entity.Book;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.service.BookServiceImpl;

@WebMvcTest(BookController.class)
public class BookControllerTest {

	@MockBean
	BookServiceImpl BookService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnBookById() throws Exception {
		Book mockBook = TestData.getMockBook();

		when(BookService.findBookById(Mockito.any(Long.class))).thenReturn(mockBook);
		this.mockMvc.perform(get(TestData.BOOK_URL)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(TestData.getBookByJson()));
	}

	@Test
	void shouldReturnSavedBook() throws Exception {
		Book mockBook = TestData.getMockBook();

		when(BookService.save(Mockito.any(Book.class))).thenReturn(mockBook);
		this.mockMvc
				.perform(post("/book").contentType(MediaType.APPLICATION_JSON).content(TestData.getBookByJson()))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(TestData.getBookByJson()));
	}

	@Test
	void shouldReturnUpdatedBook() throws Exception {
		Book mockBook = TestData.getMockBook();

		when(BookService.update(Mockito.any(Book.class), Mockito.any(Long.class))).thenReturn(mockBook);
		this.mockMvc
				.perform(put(TestData.BOOK_URL).contentType(MediaType.APPLICATION_JSON).content(TestData.getBookByJson()))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(TestData.getBookByJson()));
	}

	@Test
	void shouldDeleteBook() throws Exception {
		this.mockMvc.perform(delete(TestData.BOOK_URL)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void shouldReturnNotFoundResponse() throws Exception {

		when(BookService.findBookById(Mockito.any(Long.class))).thenThrow(new ResourceNotFoundException());
		this.mockMvc.perform(get(TestData.BOOK_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andExpect(result -> result.getResolvedException().getMessage()
						.equals("404 NOT_FOUND \"Book Not Found for given Id\""));
	}
}
