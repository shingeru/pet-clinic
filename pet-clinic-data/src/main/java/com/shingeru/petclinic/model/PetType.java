package com.shingeru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


//@Data
@Getter
@Setter
@Entity
@Table(name = "types")
public class PetType extends BaseEntity{

   @Column(name = "name ")
   private String name;
}
