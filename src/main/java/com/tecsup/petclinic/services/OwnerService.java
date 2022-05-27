package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.exception.PetNotFoundException;

public interface OwnerService {
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);
	/**
	 * 
	 * @param owner
	 * @return
	 */
	
	Owner update(Owner owner);
	
	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	void delete(Long id) throws OwnerNotFoundException;
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	Owner findById(long id) throws OwnerNotFoundException;
	/**
	 * 
	 * @param first_name
	 * @return
	 */
	
	List<Owner> findByFirst_Name(String first_name);
	/**
	 * 
	 * @param last_name
	 * @return
	 */
	
	List<Owner> findByLast_Name(String last_name);
	
	/**
	 * 
	 * @return
	 */
	Iterable<Owner> findAll();

}
