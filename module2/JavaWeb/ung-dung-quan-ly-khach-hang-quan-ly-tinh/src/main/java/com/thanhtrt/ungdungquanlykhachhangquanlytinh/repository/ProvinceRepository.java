package com.thanhtrt.ungdungquanlykhachhangquanlytinh.repository;


import com.thanhtrt.ungdungquanlykhachhangquanlytinh.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
}