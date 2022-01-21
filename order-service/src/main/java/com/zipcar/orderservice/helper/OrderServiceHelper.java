package com.zipcar.orderservice.helper;

import com.zipcar.orderservice.dto.OrderRequest;
import com.zipcar.orderservice.dto.OrderResponse;
import com.zipcar.orderservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceHelper {


    /*@Autowired
    @Qualifier("requestScopedBean")
    private Order order;*/

    public Order createOrderObject(OrderRequest orderRequest, Cart cart, User user, Address address) {
        Order order = new Order();
        order.setAccountId(user);
        order.setCartId(cart);
        order.setPaymentMode(orderRequest.getPaymentMode());
        order.setStatus(OrderStatus.ORDER_ASSIGNED);
        order.setDiscountAmountApplied(0d);
        order.setShippingAddress(address);
        //Get below total amount and shipment amount from the item microservices and calculate the total amount
        //and shipping amount and also validate the no of items is available in item database or not
        //taking default at this time.
        order.setTotalAmount(1000d);
        order.setShippingAmount(12d);
        return order;
    }

    public OrderResponse prepareResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setAccountId(order.getAccountId().getId());
        orderResponse.setShippingAmount(order.getShippingAmount());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setTotalAmount(order.getTotalAmount());
        orderResponse.setPaymentMode(order.getPaymentMode());
        orderResponse.setCartId(order.getCartId().getId());
        orderResponse.setDiscountAmountApplied(order.getDiscountAmountApplied());
        orderResponse.setShippingAddress(order.getShippingAddress().getId());
        return orderResponse;
    }
}
