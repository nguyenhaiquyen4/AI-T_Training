package com.packt.webstore.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.packt.webstore.service.ProductService;

import java.util.Arrays;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<Category, String> {
    @Autowired
    private ProductService productService;

    private List<String> allowedCategories;

    public void initialize(Category constraintAnnotation) {
        allowedCategories = Arrays.asList(constraintAnnotation.allowedCategories());
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return (allowedCategories.contains(value) ? true : false);
    }
}