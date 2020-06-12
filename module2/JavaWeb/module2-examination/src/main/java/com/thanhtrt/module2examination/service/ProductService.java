package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.Customer;
import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.model.Product;
import com.thanhtrt.module2examination.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    void save(Product product);

    void remove(Long id);
    List<Product> findAllByProvince(LoaiHang loaiHang);
    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
