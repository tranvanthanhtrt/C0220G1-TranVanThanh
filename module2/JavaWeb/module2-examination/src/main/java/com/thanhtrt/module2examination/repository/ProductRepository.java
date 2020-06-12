package com.thanhtrt.module2examination.repository;

import com.thanhtrt.module2examination.model.Customer;
import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.model.Product;
import com.thanhtrt.module2examination.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Long> {
    List<Product> findAllByLoaiHang(LoaiHang loaihang);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
