package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.LoaiHang;
import com.thanhtrt.module2examination.repository.LoaiHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoaiHangImpl implements LoaiHangService{
    @Autowired
    LoaiHangRepository loaiHangRepository;
    @Override
    public List<LoaiHang> findAll() {
        return loaiHangRepository.findAll();
    }

    @Override
    public Optional<LoaiHang> findById(Long id) {
        return loaiHangRepository.findById(id);
    }
}
