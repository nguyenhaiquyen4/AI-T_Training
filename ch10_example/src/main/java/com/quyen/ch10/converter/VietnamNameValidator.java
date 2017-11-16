package com.quyen.ch10.converter;


import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Service("validator")
public class VietnamNameValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        if (VietnameseName.class.equals(aClass))
            return true;
        return AmericanName.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors e) {
//        String[] validClass = {"VietnameseName","AmericanName"};
//        Arrays.asList(validClass).contains(o.getClass().getName());
        System.out.println(o.getClass().getCanonicalName());
        if (o.getClass().getName().equals("com.quyen.ch10.converter.VietnameseName")) {
//            VietnameseName vn = (VietnameseName)o;
            ValidationUtils.rejectIfEmpty(e, "chulot", "chulot.empty");
            System.out.println(o);
        }
        if (o.getClass().getName().equals("com.quyen.ch10.converter.AmericanName")) {
//            VietnameseName vn = (VietnameseName)o;
            ValidationUtils.rejectIfEmpty(e, "firstName", "firstName.empty");
        }
    }
}
