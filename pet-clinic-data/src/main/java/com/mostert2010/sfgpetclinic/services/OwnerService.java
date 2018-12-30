package com.mostert2010.sfgpetclinic.services;

import java.util.Set;

import com.mostert2010.sfgpetclinic.models.Owner;

public interface OwnerService {

	Owner findById(Long id);
	
	Owner findByLastName(String lastName);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
}
