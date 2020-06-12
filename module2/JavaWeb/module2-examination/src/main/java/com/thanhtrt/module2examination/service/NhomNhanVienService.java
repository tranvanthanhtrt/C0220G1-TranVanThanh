package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.model.NhomNhanVien;

import java.util.List;
import java.util.Optional;

public interface NhomNhanVienService {
    List<NhomNhanVien> findAll();

    Optional<NhomNhanVien> findById(Long id);
}
