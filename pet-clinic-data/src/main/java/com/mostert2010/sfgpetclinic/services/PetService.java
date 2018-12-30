package com.mostert2010.sfgpetclinic.services;

import java.util.Set;

import com.mostert2010.sfgpetclinic.models.Pet;

public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
