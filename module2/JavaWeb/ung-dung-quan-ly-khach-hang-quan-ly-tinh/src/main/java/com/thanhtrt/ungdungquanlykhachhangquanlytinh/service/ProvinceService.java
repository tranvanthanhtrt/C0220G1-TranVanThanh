package com.thanhtrt.ungdungquanlykhachhangquanlytinh.service;

import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}