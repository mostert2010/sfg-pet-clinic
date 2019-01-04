package com.mostert2010.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mostert2010.sfgpetclinic.models.Owner;
import com.mostert2010.sfgpetclinic.services.OwnerService;
import com.mostert2010.sfgpetclinic.services.PetService;
import com.mostert2010.sfgpetclinic.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}
	
	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		if (object == null) return null;
			
		object.getPets().forEach(pet -> {
			if (pet.getPetType() == null)
				throw new RuntimeException("Pet Type is required");
			
			if (pet.getPetType().getId() == null)
				pet.setPetType(petTypeService.save(pet.getPetType()));
				
			if (pet.getId() == null)
				pet = petService.save(pet);
		});
		
		return super.save(object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
