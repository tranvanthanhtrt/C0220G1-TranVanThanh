package com.thanhtrt.module2examination.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="sanPham")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long maHang;
    private  String name;
    @Min(value = 1,message = "giá phải lớn hơn 0")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotNull(message = "giá không để trống")
    private Long gia;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotNull(message = "số lượng không để trống")
    @Min(value = 1,message = "số lượng lớn hơn 0")

    private int soluong;
    private Date ngaytao;
    private String mota;
    @ManyToOne
    @JoinColumn(name = "loaihang_id")
    private LoaiHang loaiHang;

    public Product() {
    }

    public Long getMaHang() {
        return maHang;
    }

    public void setMaHang(Long maHang) {
        this.maHang = maHang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public LoaiHang getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHang loaiHang) {
        this.loaiHang = loaiHang;
    }
}
