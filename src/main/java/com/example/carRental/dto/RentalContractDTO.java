package com.example.carRental.dto;

import com.example.carRental.Constants.RentalStatus;
import com.example.carRental.entity.Customer;
import com.example.carRental.entity.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentalContractDTO {

    private Long id;
    private Customer customer;
    private Vehicle Vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double rentalPrice;
    private RentalStatus Status;
}
