package com.thanhtrt.module2examination.repository;

import com.thanhtrt.module2examination.model.NhanVien;
import com.thanhtrt.module2examination.model.Product;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Long> {
    Page<NhanVien> findAllByCmndContaining(String cmnd, Pageable pageable);

}
