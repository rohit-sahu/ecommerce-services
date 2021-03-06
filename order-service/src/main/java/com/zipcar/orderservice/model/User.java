package com.zipcar.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Entity for the User class.
 *
 * @since 20-01-2022
 * @author rohit-sahu
 * @version 1.0
 */
@Data
@Slf4j
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL")
})
public class User extends BaseAuditEntity<String, Long, LocalDateTime> {

    private static final long serialVersionUID = -5510115603666184167L;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    @OneToMany(mappedBy = "user", targetEntity = ContactNumber.class, cascade = CascadeType.ALL)
    private Set<ContactNumber> contactNumbers;

    @OneToMany(mappedBy = "user", targetEntity = Address.class, cascade = CascadeType.ALL)
    private List<Address> address;

    @Builder
    public User(Long id, String createdBy, String lastModifiedBy, Integer version, LocalDateTime createdDate, LocalDateTime lastModifiedDate, Boolean isDeleted,
                    Boolean isActive, String firstName, String lastName, String email, Set<ContactNumber> contactNumbers, List<Address> address) {
        super(id, createdBy, lastModifiedBy, version, createdDate, lastModifiedDate, isDeleted, isActive);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumbers = contactNumbers;
        this.address = address;
    }
}
