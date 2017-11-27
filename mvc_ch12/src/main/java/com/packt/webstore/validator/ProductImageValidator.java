package com.packt.webstore.validator;

import com.packt.webstore.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Component
public class ProductImageValidator implements Validator {
    private long allowedSize = 100000000;

    public long getAllowedSize() {
        return allowedSize;
    }

    public void setAllowedSize(long allowedSize) {
        this.allowedSize = allowedSize;
    }

    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        MultipartFile f = product.getProductImage();
        if (f != null)
            if (f.getSize() > allowedSize) {
                errors.rejectValue("productImage", "com.packt.webstore.validator.ProductImageValidator.message");
            }
    }
}
