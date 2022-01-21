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
@Table(name = "item", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class Item extends BaseAuditEntity<String, Long, LocalDateTime> {

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Enumerated(value = EnumType.STRING)
    private ItemStatus itemStatus;

    @Column
    private Long itemAvailableCount;

    @Column
    private Double itemAmount;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Cart> carts;

    public enum ItemStatus {
        NOT_SOLD, SOLD
    }
}
