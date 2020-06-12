package com.thanhtrt.ungdungquanlykhachhangquanlytinh.service.impl;


import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Customer;
import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Province;
import com.thanhtrt.ungdungquanlykhachhangquanlytinh.repository.CustomerRepository;
import com.thanhtrt.ungdungquanlykhachhangquanlytinh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
    @Override
    public List<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(firstname, pageable);
    }

}