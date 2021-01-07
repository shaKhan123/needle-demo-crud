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
import com.needle.democrud.service.AuthorService;

@WebMvcTest
public class AuthorControllerTest {

	@MockBean
	AuthorService authorService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnAuthorById() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.findById(Mockito.any(Long.class))).thenReturn(mockAuthor);
		this.mockMvc.perform(get("/author/1"))
		.andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(TestData.getAuthorByIdJson()));
	}
	
	@Test
	public void shouldReturnSavedAuthor() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.saveAuthor(Mockito.any(Author.class))).thenReturn(mockAuthor);
		this.mockMvc.perform(post("/author")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(TestData.getAuthorByIdJson()))
		.andDo(print())
		.andExpect(status().isOk())
				.andExpect(content().json(TestData.getAuthorByIdJson()));
	}
	
	@Test
	public void shouldReturnUpdatedAuthor() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.updateAuthor(Mockito.any(Author.class), 1L)).thenReturn(mockAuthor);
		this.mockMvc.perform(put("/author/1")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(TestData.getAuthorByIdJson()))
		.andDo(print())
		.andExpect(status().isOk())
				.andExpect(content().json(TestData.getAuthorByIdJson()));
	}
	
	@Test
	public void shouldDeleteAuthor() throws Exception {
		Author mockAuthor = TestData.getMockAuthor();

		when(authorService.updateAuthor(Mockito.any(Author.class), 1L)).thenReturn(mockAuthor);
		this.mockMvc.perform(delete("/author/1"))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
