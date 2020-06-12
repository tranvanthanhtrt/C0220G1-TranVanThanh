package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.NhomNhanVien;
import com.thanhtrt.module2examination.repository.NhanVienRepository;
import com.thanhtrt.module2examination.repository.NhomNhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NhomNhanVienServiceImpl implements NhomNhanVienService {
    @Autowired
    NhomNhanVienRepository nhomNhanVienRepository;
    @Override
    public List<NhomNhanVien> findAll() {
        return nhomNhanVienRepository.findAll();
    }

    @Override
    public Optional<NhomNhanVien> findById(Long id) {
        return nhomNhanVienRepository.findById(id);
    }
}
