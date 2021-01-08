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
import com.needle.democrud.entity.Author;
import com.needle.democrud.error.ResourceNotFoundException;
import com.needle.democrud.service.AuthorServiceImpl;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

	@MockBean
	AuthorServiceImpl authorService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldReturnAuthorById() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.findById(Mockito.any(Long.class))).thenReturn(mockAuthor);
		this.mockMvc.perform(get(TestData.AUTHOR_URL)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(TestData.getAuthorByJson()));
	}

	@Test
	void shouldReturnSavedAuthor() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.saveAuthor(Mockito.any(Author.class))).thenReturn(mockAuthor);
		this.mockMvc
				.perform(post("/author").contentType(MediaType.APPLICATION_JSON).content(TestData.getAuthorByJson()))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(TestData.getAuthorByJson()));
	}

	@Test
	void shouldReturnUpdatedAuthor() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.updateAuthor(Mockito.any(Author.class), Mockito.any(Long.class))).thenReturn(mockAuthor);
		this.mockMvc
				.perform(put(TestData.AUTHOR_URL).contentType(MediaType.APPLICATION_JSON).content(TestData.getAuthorByJson()))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().json(TestData.getAuthorByJson()));
	}

	@Test
	void shouldDeleteAuthor() throws Exception {
		this.mockMvc.perform(delete(TestData.AUTHOR_URL)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void shouldReturnNotFoundResponse() throws Exception {

		when(authorService.findById(Mockito.any(Long.class))).thenThrow(new ResourceNotFoundException());
		this.mockMvc.perform(get(TestData.AUTHOR_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
				.andExpect(result -> result.getResolvedException().getMessage()
						.equals("404 NOT_FOUND \"Author Not Found for given Id\""));
	}
}
