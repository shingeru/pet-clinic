package com.shingeru.petclinic.services;

import com.shingeru.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
