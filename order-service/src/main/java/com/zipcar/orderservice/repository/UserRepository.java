package com.zipcar.orderservice.repository;

import com.zipcar.orderservice.model.Order;
import com.zipcar.orderservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
