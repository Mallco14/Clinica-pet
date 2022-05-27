package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;




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
	public Owner findById(long id) throws OwnerNotFoundException {
		
		Optional<Owner> owner = ownerRepository.findById(id);
		
		if(!owner.isPresent())
			throw new OwnerNotFoundException("Record not found");
		return owner.get();
	}

	@Override
	public List<Owner> findByFirstName(String first_name) {
		List<Owner> owners=ownerRepository.findByFirstName(first_name);
		owners.stream().forEach(owner -> logger.info(""+ owner));
		return owners;
	}

	@Override
	public List<Owner> findByLastName(String last_name) {
		List<Owner> owners = ownerRepository.findByLastName(last_name);
		owners.stream().forEach(owner ->logger.info("" + owner));
		return owners;
	}

	@Override
	public Owner findByTelephone(String phone) throws OwnerNotFoundException {
		Optional<Owner> owner = Optional.of(ownerRepository.findByTelephone(phone));
		if(!owner.isPresent())
			throw new OwnerNotFoundException("Record not found");
		
		return owner.get();
	}

	@Override
	public Iterable<Owner> findAll() {
		
		return ownerRepository.findAll();
	}

}
