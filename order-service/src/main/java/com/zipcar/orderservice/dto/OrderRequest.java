package com.zipcar.orderservice.dto;

import com.zipcar.orderservice.model.PaymentMethod;
import com.zipcar.orderservice.utils.PaymentMethodTypeSubSet;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class OrderRequest {

    @NotNull
    @Positive
    @Min(value = 1, message = "{Min.OrderRequest.cartId}")
    @Max(value = Long.MAX_VALUE, message = "{Max.OrderRequest.cartId}")
    private Long cartId;

    @NotNull
    @Positive
    @Min(value = 1, message = "{Min.OrderRequest.userId}")
    @Max(value = Long.MAX_VALUE, message = "{Max.OrderRequest.userId}")
    private Long userId;

    @PaymentMethodTypeSubSet(anyOf = {PaymentMethod.NET_BANKING, PaymentMethod.DEBIT_CARD,
            PaymentMethod.CREDIT_CARD, PaymentMethod.UPI, PaymentMethod.COD})
    private PaymentMethod paymentMode;

    @NotNull
    @Positive
    @Min(value = 1, message = "{Min.OrderRequest.shippingAddress}")
    @Max(value = Long.MAX_VALUE, message = "{Max.OrderRequest.shippingAddress}")
    private Long shippingAddress;
}
