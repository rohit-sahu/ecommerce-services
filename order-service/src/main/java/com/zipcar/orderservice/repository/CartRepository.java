package com.zipcar.orderservice.repository;

import com.zipcar.orderservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
