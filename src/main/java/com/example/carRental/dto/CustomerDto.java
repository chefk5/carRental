package com.example.carRental.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String licenseNbr;
}
