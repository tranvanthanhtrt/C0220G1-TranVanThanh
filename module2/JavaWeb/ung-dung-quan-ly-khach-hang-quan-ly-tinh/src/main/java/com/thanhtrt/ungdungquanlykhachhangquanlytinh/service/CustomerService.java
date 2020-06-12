package com.thanhtrt.ungdungquanlykhachhangquanlytinh.service;

import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Customer;
import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
    List<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}