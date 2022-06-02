package com.tecsup.petclinic.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.dto.OwnerDTO;
@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerJhon {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(OwnerControllerJhon.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void testDeleteOwner() throws Exception{
		
		 String nombre = "Jhon";
		 String apellido = "Mallcco";
		 String address = "Av.Dominicos mz";
		 String city = "Callao";
		 String telephone = "985475121";
		 
		 //Crear el Objeto Owner;
		 
		 OwnerDTO od = new OwnerDTO(nombre,apellido,address,city,telephone);
		 
		 ResultActions mcs = mockMvc.perform(post("/owners")
				 .content(om.writeValueAsString(od))
				 .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				 .andDo(print())
				 .andExpect(status().isCreated());
	
		
		 
		 //Declarar variables
		 String responde = mcs.andReturn().getResponse().getContentAsString();
		 Integer id = JsonPath.parse(responde).read("$.id");
		 
		 mockMvc.perform(delete("/owners/" + id ))
         /*.andDo(print())*/
        .andExpect(status().isOk());
	}

}