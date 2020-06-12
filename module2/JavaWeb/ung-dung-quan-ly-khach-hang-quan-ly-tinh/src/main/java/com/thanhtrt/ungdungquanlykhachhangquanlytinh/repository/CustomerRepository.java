package com.thanhtrt.ungdungquanlykhachhangquanlytinh.repository;

import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Customer;
import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByProvince(Province province);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
