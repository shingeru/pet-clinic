package com.shingeru.petclinic.bootstrap;

import com.shingeru.petclinic.model.Owner;
import com.shingeru.petclinic.model.PetType;
import com.shingeru.petclinic.model.Vet;
import com.shingeru.petclinic.services.OwnerService;
import com.shingeru.petclinic.services.PetTypeService;
import com.shingeru.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatgPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Adam");
        owner1.setLastName("Wenson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("John");
        owner2.setLastName("Walker");

        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Doe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jim");
        vet2.setLastName("Lee");


        vetService.save(vet2);

        System.out.println("Loading vets..");

    }
}
