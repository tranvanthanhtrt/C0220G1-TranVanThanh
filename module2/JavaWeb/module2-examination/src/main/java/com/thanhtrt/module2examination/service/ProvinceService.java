package com.thanhtrt.module2examination.service;


import com.thanhtrt.module2examination.model.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}