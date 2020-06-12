package com.thanhtrt.module2examination.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="loaihang")
public class LoaiHang {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = Product.class)
    private List<Product> sanpham;

    public LoaiHang() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getSanpham() {
        return sanpham;
    }

    public void setSanpham(List<Product> sanpham) {
        this.sanpham = sanpham;
    }
}
