package com.example.carRental.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer extends User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDateTime dateOfBirth;

    @Column(name = "license_number")
    private String licenseNbr;

    public Customer(Long id, String email, String password, String firstName, String lastName, LocalDateTime dateOfBirth, String licenseNbr) {
        super( email, password, null);  // Initialize superclass fields
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.licenseNbr = licenseNbr;
    }
}
