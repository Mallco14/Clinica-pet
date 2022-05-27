package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;
@Service
public class OwnerServiceImpl implements OwnerService {
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);
	
	@Autowired
	OwnerRepository ownerRepository;
	
	
	@Override
	public Owner create(Owner owner) {
		
		return ownerRepository.save(owner);
	}

	@Override
	public Owner update(Owner owner) {
		
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Long id) throws OwnerNotFoundException {
		Owner owner = findById(id);
		ownerRepository.delete(owner);
	}

	@Override
	public List<Owner> findByNombre(String nombre) {
		List<Owner> owners = ownerRepository.findByNombre(nombre);
		owners.stream().forEach(owner -> logger.info(""+owner));
		return owners;
	}

	@Override
	public List<Owner> findByApellido(String apellido) {
		List<Owner> owners = ownerRepository.findByApellido(apellido);
		owners.stream().forEach(owner -> logger.info(""+owner));
		return owners;
	}

	@Override
	public Iterable<Owner> findAll() {
		
		return ownerRepository.findAll();
	}

	@Override
	public Owner findById(Long id) throws OwnerNotFoundException {
		Optional<Owner> owner = ownerRepository.findById(id);
		if( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
		
		return owner.get();
	}


}
