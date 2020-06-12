package com.thanhtrt.casestudyweb.service.customer;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Optional<Customer> finById(String id);
    void save(Customer customer);
    void remove(String id);


    Page<Customer> findAllByNameContaining(String s, Pageable pageable);
}
