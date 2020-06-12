package com.thanhtrt.baitapvalidateformdangky.model;

import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {

    }
    public static boolean validateEmail(String value) {
        String PATTERN = "[a-z 1-9]+@[a-z 1-9]+[.]([a-z 1-9]+)$";
        return Pattern.matches(PATTERN, value);
    }
}
