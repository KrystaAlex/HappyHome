package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class EnufPartsValidator implements ConstraintValidator<ValidEnufParts, Product> {
    @Autowired
    private ApplicationContext context;
    private ProductService productService;
    public static  ApplicationContext myContext;

    @Override
    public void initialize(ValidEnufParts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext context) {
        if (product.getId() != 0) {
            return true;
        }
            Product myProduct = productService.findById((int) product.getId());
            for (Part p : myProduct.getParts()) {
                int neededParts = product.getInv();
                int availableParts = p.getInv();
                if (availableParts < neededParts) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate("There are not enough parts to complete this task.")
                            .addConstraintViolation();
                    return false;
                }

            }
            return true;
            }
        }
