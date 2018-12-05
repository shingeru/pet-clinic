package com.shingeru.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "speciaity")
public class Speciality extends BaseEntity {


    @Column(name = "description")
    private String description;
}
