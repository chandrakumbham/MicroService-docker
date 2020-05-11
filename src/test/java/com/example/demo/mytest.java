package com.example.demo;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Note;
import com.example.demo.repository.NoteRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@WebMvcTest(value=controller.class)
public class mytest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private controller mycontroller;
	@Test
	public void getallnotes() throws Exception {
		
		Note note =  new Note();
		note.setContent("content");
		note.setEmail("email");
		note.setMessage("message");
		note.setTitle("title");
		note.setId(1l);
		String inputInJson = this.mapToJson(note);
		String URI = "/api/notes";
		
		List<Note> noteList = new ArrayList<>();
		noteList.add(note);
		
Mockito.when(mycontroller.getAllNotes()).thenReturn(noteList);
		
RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
		URI).accept(
		MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();	
		
		String expectedJson = this.mapToJson(noteList);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
		
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());

		
	}
	
	
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

}
