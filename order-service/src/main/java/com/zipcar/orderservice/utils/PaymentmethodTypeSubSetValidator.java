package com.zipcar.orderservice.utils;

import com.zipcar.orderservice.model.PaymentMethod;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PaymentmethodTypeSubSetValidator implements ConstraintValidator<PaymentMethodTypeSubSet, PaymentMethod> {

    private PaymentMethod[] subset;

    @Override
    public void initialize(PaymentMethodTypeSubSet constraintAnnotation) {
        this.subset = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(PaymentMethod value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
