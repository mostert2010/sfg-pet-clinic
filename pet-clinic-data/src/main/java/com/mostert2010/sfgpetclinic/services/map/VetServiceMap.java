package com.mostert2010.sfgpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mostert2010.sfgpetclinic.models.Specialty;
import com.mostert2010.sfgpetclinic.models.Vet;
import com.mostert2010.sfgpetclinic.services.SpecialtyService;
import com.mostert2010.sfgpetclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

	private final SpecialtyService specialtyService;
	
	public VetServiceMap(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		
		if (object == null) return null;
		
		object.getSpecialties().forEach(sp -> {
			if (sp.getId() == null)
				sp = specialtyService.save(sp);
		});
		
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
