package com.shingeru.petclinic.bootstrap;

import com.shingeru.petclinic.model.Owner;
import com.shingeru.petclinic.model.Pet;
import com.shingeru.petclinic.model.PetType;
import com.shingeru.petclinic.model.Vet;
import com.shingeru.petclinic.services.OwnerService;
import com.shingeru.petclinic.services.PetTypeService;
import com.shingeru.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
