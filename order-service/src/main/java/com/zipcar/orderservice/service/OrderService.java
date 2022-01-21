package com.zipcar.orderservice.service;

import com.zipcar.orderservice.dto.OrderRequest;
import com.zipcar.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order getOrderById(Long id);
    List<Order> getOrderByUserId(Long userId);
    Order generateNewOrder(OrderRequest orderRequest);
    void deleteOrderById(Long id);
}
