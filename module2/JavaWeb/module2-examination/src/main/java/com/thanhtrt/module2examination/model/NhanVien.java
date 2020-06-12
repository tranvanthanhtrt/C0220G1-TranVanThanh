package com.thanhtrt.module2examination.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Entity
@Table(name = "nhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long maNhanVien;
    @NotEmpty(message = "ten khong de trong")
    private String ten;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "ngay sinh khong duoc de trong")
    private Date birthday;
    @NotNull(message = "Gender not null!")
    private String gender;
    @Pattern(regexp = "([0-9]{10})$", message = "CMND co 10 chu so")

    private String cmnd;
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)([0-9]{7})$", message = "miss match phone number")
    private String phoneNumber;
    @Pattern(regexp = "[a-z 1-9]+@[a-z 1-9]+[.]([a-z 1-9]+)$",message = "email dinh dang abc@abc.abc")
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "nhomNhanVien_maNhom")
    private NhomNhanVien nhomNhanVien;

    public NhanVien() {
    }

    public Long getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Long maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public NhomNhanVien getNhomNhanVien() {
        return nhomNhanVien;
    }

    public void setNhomNhanVien(NhomNhanVien nhomNhanVien) {
        this.nhomNhanVien = nhomNhanVien;
    }
}
