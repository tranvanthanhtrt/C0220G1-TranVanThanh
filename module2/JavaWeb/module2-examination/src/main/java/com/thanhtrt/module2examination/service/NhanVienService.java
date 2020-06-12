package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.model.NhanVien;
import com.thanhtrt.module2examination.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NhanVienService {
    Page<NhanVien> findAll(Pageable pageable);

    Optional<NhanVien> findById(Long id);

    void save(NhanVien nhanVien);

    void remove(Long id);
    Page<NhanVien> findAllByCmndContaining(String name, Pageable pageable);
}
