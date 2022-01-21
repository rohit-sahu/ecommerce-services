package com.zipcar.orderservice.repository;

import com.zipcar.orderservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
