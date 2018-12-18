package com.shingeru.petclinic.services;

import com.shingeru.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

    List<Owner> findByLastNameLike(String lastName);

}
