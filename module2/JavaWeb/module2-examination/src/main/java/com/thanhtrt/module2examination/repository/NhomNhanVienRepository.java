package com.thanhtrt.module2examination.repository;

import com.thanhtrt.module2examination.model.NhomNhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhomNhanVienRepository extends JpaRepository<NhomNhanVien,Long> {
}
