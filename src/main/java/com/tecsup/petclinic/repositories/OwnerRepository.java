package com.tecsup.petclinic.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;



@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

	List<Owner> findByFirstName(String first_name);
	
	List<Owner> findByLastName(String last_name);
	
	Owner findByTelephone(String phone);

}
