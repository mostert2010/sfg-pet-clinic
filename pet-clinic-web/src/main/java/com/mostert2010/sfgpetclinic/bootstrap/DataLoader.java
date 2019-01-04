package com.mostert2010.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mostert2010.sfgpetclinic.models.Owner;
import com.mostert2010.sfgpetclinic.models.Pet;
import com.mostert2010.sfgpetclinic.models.PetType;
import com.mostert2010.sfgpetclinic.models.Specialty;
import com.mostert2010.sfgpetclinic.models.Vet;
import com.mostert2010.sfgpetclinic.services.OwnerService;
import com.mostert2010.sfgpetclinic.services.PetService;
import com.mostert2010.sfgpetclinic.services.PetTypeService;
import com.mostert2010.sfgpetclinic.services.SpecialtyService;
import com.mostert2010.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final PetService petService;
	private final SpecialtyService specialtyService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			PetService petService, SpecialtyService specialtyService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.petService = petService;
		this.specialtyService = specialtyService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();
		
		if (count == 0)
			loadData();
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Brickerel");
		owner1.setCity("Miami");
		owner1.setTelephone("21321323");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("123 Brickerel");
		owner2.setCity("Miami");
		owner2.setTelephone("21321323");

		Pet fionasPet = new Pet();
		fionasPet.setPetType(savedCatPetType);
		fionasPet.setOwner(owner2);
		fionasPet.setBirthDate(LocalDate.now());
		fionasPet.setName("Cat");
		owner2.getPets().add(fionasPet);
		
		ownerService.save(owner2);
		System.out.println("Loaded Owners....");
///////////////////////////////////////////////////////////////////////////////////////
		
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);
		
		Specialty surgery = new Specialty();
		radiology.setDescription("Surgery");
		//Specialty savedSurgery = specialtyService.save(surgery);
		
		Specialty dentistry = new Specialty();
		radiology.setDescription("Dentistry");
		//Specialty savedDentistry = specialtyService.save(dentistry);

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialties().add(surgery);
		vet2.getSpecialties().add(dentistry);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
