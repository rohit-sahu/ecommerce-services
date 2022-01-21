package com.zipcar.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zipcar.orderservice.model.*;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderResponse implements Serializable {

    private OrderStatus status;

    private Long cartId;

    private Long accountId;

    private Double totalAmount;

    private Double shippingAmount;

    private Double discountAmountApplied;

    private PaymentMethod paymentMode;

    private Long shippingAddress;
}
