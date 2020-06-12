package com.thanhtrt.module2examination.service;

import com.thanhtrt.module2examination.model.NhanVien;
import com.thanhtrt.module2examination.model.Product;
import com.thanhtrt.module2examination.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class NhanVienServiceImpl implements NhanVienService{
    @Autowired
    NhanVienRepository nhanVienRepository;
    @Override
    public Page<NhanVien> findAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public Optional<NhanVien> findById(Long id) {
        return nhanVienRepository.findById(id);
    }

    @Override
    public void save(NhanVien nhanVien) {
nhanVienRepository.save(nhanVien);
    }

    @Override
    public void remove(Long id) {
nhanVienRepository.deleteById(id);
    }

    @Override
    public Page<NhanVien> findAllByCmndContaining(String name, Pageable pageable) {
        return nhanVienRepository.findAllByCmndContaining(name,pageable);
    }
}
