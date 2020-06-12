package com.thanhtrt.casestudyweb.model.validator;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;
import java.util.regex.Pattern;

public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customer customer=(Customer) o;
        String PATTERN = "[a-z 1-9]+@[a-z 1-9]+\\.([a-z 1-9]+)$";
        if (!customer.getEmail().matches(PATTERN)){
            errors.rejectValue("email","email.errorType");
        }
        if (!(customer.getEmail().length() >5)){
            errors.rejectValue("email","email.errorLength");
        }
//        if(customer.getBirthday()==null){
//            errors.rejectValue("birthday","birthday.type");
//        }

    }
}
