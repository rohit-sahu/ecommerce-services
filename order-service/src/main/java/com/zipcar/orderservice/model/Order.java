package com.zipcar.orderservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Order extends BaseAuditEntity<String, Long, LocalDateTime> {

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID", referencedColumnName = "ID")
    private Cart cartId;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User accountId;

    @Column
    private Double totalAmount;

    @Column
    private Double shippingAmount;

    @Column
    private Double discountAmountApplied;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethod paymentMode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SHIPPING_ADDRESS_ID", referencedColumnName = "ID")
    private Address shippingAddress;
}
