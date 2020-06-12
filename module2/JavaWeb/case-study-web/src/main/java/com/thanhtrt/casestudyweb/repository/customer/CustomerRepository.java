package com.thanhtrt.casestudyweb.repository.customer;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findAllByOrderByIdAsc(Pageable pageable);
    Page<Customer> findAllByNameContaining(String s, Pageable pageable);

}
