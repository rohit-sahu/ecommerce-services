package com.zipcar.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Table(name = "CONTACT_NUMBER")
public class ContactNumber extends BaseAuditEntity<String, Long, LocalDateTime> {

    @Column(nullable = true, length=10)
    private String areaCode;

    @Column(nullable = true, length=10)
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column(unique = true, nullable = true, length=20)
    private String subscriberNumber;

    @Column(nullable = true, length=5)
    private String countryCode;

    @Column(nullable = true, length=50)
    private String serviceProvider;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @Builder
    public ContactNumber(Long id, String createdBy, String lastModifiedBy, Integer version, LocalDateTime createdDate, LocalDateTime lastModifiedDate, Boolean isDeleted,
                         Boolean isActive, String areaCode, ContactType contactType, String subscriberNumber, String countryCode, String serviceProvider) {
        super(id, createdBy, lastModifiedBy, version, createdDate, lastModifiedDate, isDeleted, isActive);
        this.areaCode = areaCode;
        this.contactType = contactType;
        this.subscriberNumber = subscriberNumber;
        this.countryCode = countryCode;
        this.serviceProvider = serviceProvider;
    }

    public enum ContactType {
        MOBILE, LANDLINE
    }
}
