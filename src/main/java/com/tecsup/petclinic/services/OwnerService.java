package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

public interface OwnerService {
	Owner create(Owner owner);
	
	Owner update(Owner owner);
	
	void delete(Long id) throws OwnerNotFoundException;
	
	Owner findById(Long id) throws OwnerNotFoundException;
	
	List<Owner> findByNombre(String nombre);
	
	List<Owner> findByApellido(String apellido);
	
	Iterable<Owner> findAll();
}
