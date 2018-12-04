package com.shingeru.petclinic.bootstrap;

import com.shingeru.petclinic.model.Owner;
import com.shingeru.petclinic.model.Vet;
import com.shingeru.petclinic.services.OwnerService;
import com.shingeru.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
//        ownerService = new OwnerServiceMap();
//        vetService = new VetServiceMap();
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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