package com.zipcar.orderservice.repository;

import com.zipcar.orderservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
