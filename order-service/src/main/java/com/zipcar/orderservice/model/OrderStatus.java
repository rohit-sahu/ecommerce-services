package com.zipcar.orderservice.model;

public enum OrderStatus {
    ORDER_CREATED,
    ORDER_ASSIGNED,
    ORDER_PREPARING,
    ORDER_PREPARED,
    COURIER_ASSIGNED,
    ORDER_PICKED_UP,
    ORDER_DELIVERING,
    ORDER_DELIVERED,
    ORDER_PLACED
}
