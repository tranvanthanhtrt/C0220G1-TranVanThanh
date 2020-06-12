package com.thanhtrt.casestudyweb.model.customer;

import com.thanhtrt.casestudyweb.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerTypes")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public CustomerType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CustomerType() {
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
