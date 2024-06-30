package com.example.carRental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class User {



    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = true)
    private String password;
    private Long lastLogin;
}
