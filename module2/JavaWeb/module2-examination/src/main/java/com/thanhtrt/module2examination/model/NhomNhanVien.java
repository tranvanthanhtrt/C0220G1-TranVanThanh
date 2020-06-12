package com.thanhtrt.module2examination.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "nhomNhanVien")
public class NhomNhanVien {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long maNhom;

    private String tenNhom;

    @OneToMany(targetEntity = NhanVien.class)
    private List<NhanVien> nhanVien;

    public NhomNhanVien() {
    }

    public Long getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(Long maNhom) {
        this.maNhom = maNhom;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    public void setTenNhom(String tenNhom) {
        this.tenNhom = tenNhom;
    }

    public List<NhanVien> getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(List<NhanVien> nhanVien) {
        this.nhanVien = nhanVien;
    }
}
