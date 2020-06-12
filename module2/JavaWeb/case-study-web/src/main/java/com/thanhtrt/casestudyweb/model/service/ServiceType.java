package com.thanhtrt.casestudyweb.model.service;
import com.thanhtrt.casestudyweb.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "serviceTypes")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Service.class)
    private List<Service> customers;

    public ServiceType() {
    }


    public List<Service> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Service> customers) {
        this.customers = customers;
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
