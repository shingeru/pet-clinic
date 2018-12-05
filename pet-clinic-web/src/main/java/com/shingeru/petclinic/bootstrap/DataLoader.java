package com.shingeru.petclinic.bootstrap;

import com.shingeru.petclinic.model.*;
import com.shingeru.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialitesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialitesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitesService = specialitesService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatgPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Adam");
        owner1.setLastName("Wenson");
        owner1.setAddress("123123 first Av");
        owner1.setCity("Miami");
        owner1.setPhone("123123123");

        Pet adamsPet = new Pet();
        adamsPet.setPetType(savedDogPetType);
        adamsPet.setOwner(owner1);
        adamsPet.setBirthData(LocalDate.now());
        adamsPet.setName("Atos");
        owner1.getPets().add(adamsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Walker");
        owner2.setAddress("Marholand RV");
        owner2.setCity("Hollywood");
        owner2.setPhone("2342342");

        Pet fionaPet = new Pet();
        fionaPet.setPetType(saveCatgPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthData(LocalDate.now());
        fionaPet.setName("Princes");
        owner2.getPets().add(fionaPet);

        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitesService.save(surgery);

        Speciality dentisty = new Speciality();
        dentisty.setDescription("Dentisty");
        Speciality savedDentistry = specialitesService.save(dentisty);


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Doe");
        vet1.getSpecialities().add(savedRadiology);
        vet1.getSpecialities().add(savedSurgery);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jim");
        vet2.setLastName("Lee");
        vet2.getSpecialities().add(savedDentistry);


        vetService.save(vet2);

        Visit visit1 = new Visit();
        visit1.setPet(fionaPet);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Sneezy cat...");

        visitService.save(visit1);




        System.out.println("Loading vets..");
    }
}
