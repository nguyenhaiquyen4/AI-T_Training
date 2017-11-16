package com.quyen.ch10.converter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String... args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        VietnameseName thd = ctx.getBean(VietnameseName.class);
        AmericanName donaldTrump = ctx.getBean("donaldTrump", AmericanName.class);
        ConversionService conversionService = ctx.getBean("conversionService", ConversionService.class);
        VietnameseName donaldTruminVietnam = conversionService.convert(donaldTrump, VietnameseName.class);
        AmericanName tranHungDaoinUSA = conversionService.convert(thd, AmericanName.class);
        VietnameseName lincolninVietnam = conversionService.convert(ctx.getBean("lincoln", AmericanName.class), VietnameseName.class);

        System.out.println(donaldTruminVietnam);
        System.out.println(tranHungDaoinUSA);
        System.out.println(lincolninVietnam);

        String[] aa = conversionService.convert("a,b,c", String[].class);
        System.out.println(aa[1]);

        ConversionService conversionService1 = ctx.getBean("customConversionServiceFactoryBean", ConversionService.class);
        System.out.println(thd);
        System.out.println(conversionService1.convert(donaldTrump, String.class));
//        conversionService.

        Validator validator = ctx.getBean("validator", Validator.class);
        BeanPropertyBindingResult result =
                new BeanPropertyBindingResult(donaldTruminVietnam, "tranHungDao");
        ValidationUtils.invokeValidator(validator, thd, result);
        List<ObjectError> errors = result.getAllErrors();
        System.out.println("No of validation errors: " + errors.size());
        for (ObjectError error : errors) {
            System.out.println(error.getCode());
        }

        thd.setTen("A");
        System.out.println(thd);
        javax.validation.Validator v = ctx.getBean("localValidatorFactoryBean", javax.validation.Validator.class);
        Set<ConstraintViolation<VietnameseName>> aaa = v.validate(thd);
        listViolations(aaa);
    }

    private static void listViolations(Set<ConstraintViolation<VietnameseName>> violations) {
        System.out.println("No. of violations: " + violations.size());
        for (ConstraintViolation<VietnameseName> violation : violations) {
            System.out.println("Validation error for property: " + violation.getPropertyPath()
                    + " with value: " + violation.getInvalidValue()
                    + " with error message: " + violation.getMessage());
        }
    }
}
