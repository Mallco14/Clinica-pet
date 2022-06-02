package com.tecsup.petclinic.controllers;



import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tecsup.petclinic.dto.OwnerDTO;
import com.tecsup.petclinic.entities.Pet;


/**
* 
*/
@AutoConfigureMockMvc
@SpringBootTest
public class OwnerControllerMelany {

	private static final Logger logger 
			= LoggerFactory.getLogger(OwnerControllerMelany.class);

  private static final ObjectMapper om = new ObjectMapper();
  
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetOwner() throws Exception {

		//int SIZE = 216;
		int ID_FIRST = 1;
		//int ID_LAST = 332;  

		this.mockMvc.perform(get("/owners"))
					.andExpect(status().isOk()) // HTTP 200
					.andExpect(content().contentType(MediaType.APPLICATION_JSON))
								    // ACTUAL      EXPECTED 
					//.andExpect(jsonPath("$", hasSize(SIZE)))
					.andExpect(jsonPath("$[0].id", is(ID_FIRST)));
					//.andExpect(jsonPath("$[212].id", is(ID_LAST)));
	}
	

	/**
	 * 
	 * @throws Exception
	 * 
	 */
	
	@Test
	public void testFindOwnerKO() throws Exception {

		int ID_SEARCH = 666;

		
		mockMvc.perform(get("/owner/" + ID_SEARCH)) // Finding object with ID = 666
				.andExpect(status().isNotFound());

	}
	
	/**
	 * @throws Exception
	 */
  
}
 