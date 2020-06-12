package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.model.Product;
import com.thanhtrt.module2examination.model.Province;
import com.thanhtrt.module2examination.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByProvince(LoaiHang loaiHang) {
        return productRepository.findAllByLoaiHang(loaiHang);
    }

    @Override
    public Page<Product> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name,pageable);
    }
}
