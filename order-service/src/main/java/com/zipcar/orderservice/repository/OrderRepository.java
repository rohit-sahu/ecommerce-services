package com.zipcar.orderservice.repository;

import com.zipcar.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<List<Order>> findOrderByAccountIdAndIsActive(Long userId, Boolean isActive);
}
