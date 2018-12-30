package com.mostert2010.sfgpetclinic.services;

import java.util.Set;

import com.mostert2010.sfgpetclinic.models.Vet;

public interface VetService {

	Vet findById(Long id);

	Vet save(Vet vet);

	Set<Vet> findAll();
}
