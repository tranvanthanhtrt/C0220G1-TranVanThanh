package com.thanhtrt.casestudyweb.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rentTypes")
public class TypeOfRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long rent;
    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

    public TypeOfRent() {
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}