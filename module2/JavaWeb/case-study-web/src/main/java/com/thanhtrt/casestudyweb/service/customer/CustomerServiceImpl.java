package com.thanhtrt.casestudyweb.service.customer;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAllByOrderByIdAsc(pageable);
    }

    @Override
    public Optional<Customer> finById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String s, Pageable pageable) {
        return customerRepository.findAllByNameContaining(s,pageable);
    }
}
