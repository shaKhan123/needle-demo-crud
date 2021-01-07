package com.needle.democrud.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

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
		this.mockMvc.perform(get("/author/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(TestData.getAuthorByIdJson()));
	}
}
