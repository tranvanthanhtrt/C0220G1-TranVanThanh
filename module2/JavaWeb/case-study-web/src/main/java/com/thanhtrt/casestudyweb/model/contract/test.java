package com.thanhtrt.casestudyweb.model.contract;

import java.util.regex.Pattern;

public class test {
    public static boolean validateNameService(String service) {
        String PATTERN = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)([0-9]{7})$";
        return Pattern.matches(PATTERN, service);
    }}
