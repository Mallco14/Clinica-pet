package com.tecsup.petclinic.controllers;

import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.is;
import com.tecsup.petclinic.dto.OwnerDTO;

@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerDiego {
	private static final Logger logger 
		= LoggerFactory.getLogger(OwnerController.class);
	private static final ObjectMapper om = new ObjectMapper();
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testCreateOwner() throws Exception{
		String OWNER_NAME = "Pepe";
        String OWNER_LASTNAME="El vivo";
        String OWNER_ADRESS="Curva del diablo";
        String OWNER_CITY="S.J.L";
        String OWNER_CELAR="6085551020";
        
        OwnerDTO newOwner = new OwnerDTO(OWNER_NAME, OWNER_LASTNAME, OWNER_ADRESS, OWNER_CITY, OWNER_CELAR);
        
        logger.info(newOwner.toString());
        logger.info(om.writeValueAsString(newOwner));
        
        mockMvc.perform(post("/owners")
        		.content(om.writeValueAsString(newOwner))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
        		.andDo(print())
        		.andExpect(status().isCreated())
        		.andExpect(jsonPath("$.nombre",is(OWNER_NAME)))
        		.andExpect(jsonPath("$.apellido",is(OWNER_LASTNAME)))
        		.andExpect(jsonPath("$.address",is(OWNER_ADRESS)))
        		.andExpect(jsonPath("$.city",is(OWNER_CITY)))
        		.andExpect(jsonPath("$.telephone",is(OWNER_CELAR)));
	}
}
