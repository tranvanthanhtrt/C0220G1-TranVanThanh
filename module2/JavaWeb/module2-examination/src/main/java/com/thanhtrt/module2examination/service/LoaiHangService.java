package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.LoaiHang;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface LoaiHangService {
     List<LoaiHang> findAll();

    Optional<LoaiHang> findById(Long id);
}
