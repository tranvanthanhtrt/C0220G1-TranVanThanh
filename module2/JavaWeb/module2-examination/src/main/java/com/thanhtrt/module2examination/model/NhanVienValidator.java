package com.thanhtrt.module2examination.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class NhanVienValidator  implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
NhanVien nhanVien=(NhanVien) o;
//        Date date=new Date(System.currentTimeMillis());
//        int year=date.getYear();
//if ((year-nhanVien.getBirthday().getYear()<18)){
//    errors.rejectValue("birthday","birthday.year");
//        }
    }
}
