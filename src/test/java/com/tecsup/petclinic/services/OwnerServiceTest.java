package com.tecsup.petclinic.services;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
public class OwnerServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);
	@Autowired
	private OwnerService ownerService;
	
	@Test
	public void testFindOwnerById() {
		long ID = 1;
		String NOMBRE = "George";
		Owner owner = null;
		
		try {
			owner = ownerService.findById(ID);
		}catch(OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info(""+ owner);
		assertThat(owner.getNombre(),is(NOMBRE));
	}
	
	@Test
	public void testFindOwnerNombre() {
		String NOMBRE = "George";
		int SIZE_EXPECTED = 1;
		List<Owner> owners = ownerService.findByNombre(NOMBRE);
		assertThat(owners.size(),is(SIZE_EXPECTED));
	}
	
	@Test
	public void testFindOwnerApellido() {
		String APELLIDO = "Davis";
		int SIZE_EXPECTED = 2;
		List<Owner> owners = ownerService.findByApellido(APELLIDO);
		assertThat(owners.size(),is(SIZE_EXPECTED));
	}
	
	@Test
	public void testCreateOwner(){
        String OWNER_NAME = "Pepe";
        String OWNER_LASTNAME="El vivo";
        String OWNER_ADRESS="Curva del diablo";
        String OWNER_CITY="S.J.L";
        String OWNER_CELAR="6085551020";

        Owner owner= new Owner(OWNER_NAME,OWNER_LASTNAME , OWNER_ADRESS,  OWNER_CITY, OWNER_CELAR);

        Owner ownerCreated = ownerService.create(owner);

        logger.info("OWNER CREATED:" +ownerCreated);

        //ACTUAL                       , EXPECTED
        assertThat(ownerCreated.getId(), notNullValue());
        assertThat(ownerCreated.getNombre(), is(OWNER_NAME));
        assertThat(ownerCreated.getApellido(), is(OWNER_LASTNAME));
        assertThat(ownerCreated.getAddress(), is(OWNER_ADRESS));
        assertThat(ownerCreated.getCity(), is(OWNER_CITY));
        assertThat(ownerCreated.getTelephone(), is(OWNER_CELAR));
    }
	
	@Test
	public void testUpdateOwner() {
		String FIRST_NAME = "George";
		String LAST_NAME = "Franklin";
		String ADDRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		String TELEPHONE = "6085551023";
		long create_id = -1;
		
		String UP_FIRST_NAME = "Pedro";
		String UP_LAST_NAME = "Frans";
		String UP_ADDRESS = "112 W. Miraflores St";
		String UP_CITY = "Lima";
		String UP_TELEPHONE = "987678765";
		
		Owner owner = new Owner(FIRST_NAME,LAST_NAME,ADDRESS,CITY,TELEPHONE);
		
		//CREATE RECORD
		logger.info(">" + owner);
		Owner ownerCreated = ownerService.create(owner);
		////
		logger.info(">>" + ownerCreated);
		
		create_id = ownerCreated.getId();
		//PREPARE DATA FOR UPDATE
		
		ownerCreated.setNombre(UP_FIRST_NAME);
		ownerCreated.setApellido(UP_LAST_NAME);
		ownerCreated.setAddress(UP_ADDRESS);
		ownerCreated.setCity(UP_CITY);
		ownerCreated.setTelephone(UP_TELEPHONE);
		
		//EXECUTE UPDATE
		Owner upgradeOwner = ownerService.update(ownerCreated);
		logger.info(">>>>" + upgradeOwner);
		
		//ACTUAL 			EXPECTED
		assertThat(create_id,notNullValue());
		assertThat(upgradeOwner.getId(), is(create_id));
		assertThat(upgradeOwner.getNombre(), is(UP_FIRST_NAME));
		assertThat(upgradeOwner.getApellido(),is(UP_LAST_NAME));
		assertThat(upgradeOwner.getAddress(),is(UP_ADDRESS));
		assertThat(upgradeOwner.getCity(),is(UP_CITY));
		assertThat(upgradeOwner.getTelephone(),is(UP_TELEPHONE));
	}
	@Test
	public void testDeleteOwner() {
		String FIRST_NAME = "George";
		String LAST_NAME = "Franklin";
		String ADDRESS = "110 W. Liberty St.";
		String CITY = "Madison";
		String TELEPHONE = "6085551023";
		
		Owner owner = new Owner(FIRST_NAME,LAST_NAME,ADDRESS,CITY,TELEPHONE);
		owner = ownerService.create(owner);
		logger.info(""+owner);
		try {
			ownerService.delete(owner.getId());
		}catch(OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		try {
			ownerService.findById(owner.getId());
			fail("Owner id = " + owner.getId() + " has not delete");
			
		}catch(OwnerNotFoundException e) {
			
		}
	}
	
}
