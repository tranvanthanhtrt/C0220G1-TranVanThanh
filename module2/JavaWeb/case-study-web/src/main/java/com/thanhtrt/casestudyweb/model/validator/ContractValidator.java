package com.thanhtrt.casestudyweb.model.validator;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContractValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Contract contract=(Contract) o;
        if(contract.getStartDay()==null){
            errors.rejectValue("startDay","startDay.error");
        }else
        if(contract.getEndDay()==null){
            errors.rejectValue("endDay","endDay.error");
        }else
        if(contract.getStartDay().after(contract.getEndDay())){
            errors.rejectValue("endDay","endDay.error");
        }

    }
}
