package com.shingeru.petclinic.bootstrap;

import com.shingeru.petclinic.model.Owner;
import com.shingeru.petclinic.model.Vet;
import com.shingeru.petclinic.services.OwnerService;
import com.shingeru.petclinic.services.VetService;
import com.shingeru.petclinic.services.map.OwnerServiceMap;
import com.shingeru.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Adam");
        owner1.setLastName("Wenson");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("John");
        owner2.setLastName("Walker");

        ownerService.save(owner2);

        System.out.println("Loading owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Doe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jim");
        vet2.setLastName("Lee");


        vetService.save(vet2);

        System.out.println("Loading vets..");

    }
}
