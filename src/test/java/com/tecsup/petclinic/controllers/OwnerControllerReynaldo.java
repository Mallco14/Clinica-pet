package com.tecsup.petclinic.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerReynaldo {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testFindOwnerOK() throws Exception{
		
		int Id_search =1;
		String first_name="George";
		String last_name = "Franklin";
		String address = "110 W. Liberty St.";
		String city = "Madison";
		String telephone = "6085551023";
		
		mockMvc.perform(get("/owners/" + Id_search))  // Finding object with ID = 1
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		//.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.nombre", is(first_name)))
		.andExpect(jsonPath("$.apellido", is(last_name)))
		.andExpect(jsonPath("$.address", is(address)))
		.andExpect(jsonPath("$.city", is(city)))
		.andExpect(jsonPath("$.telephone", is(telephone)));
		


	}
}
