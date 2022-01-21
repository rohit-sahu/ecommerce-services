package com.zipcar.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Cart extends BaseAuditEntity<String, Long, LocalDateTime> {

    @Enumerated(value = EnumType.STRING)
    private CartStatus cartStatus;

    @Column
    private Double cartAmount;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User accountId;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "Cart_Item",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "item_id") }
    )
    private List<Item> items;
}
