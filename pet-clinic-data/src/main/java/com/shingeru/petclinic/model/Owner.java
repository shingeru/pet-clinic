package com.shingeru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class Owner extends Person {

    private String address;
    private String city;
    private String phone;

    private Set<Pet> pets = new HashSet<>();
}
