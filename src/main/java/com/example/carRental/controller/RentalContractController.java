package com.example.carRental.controller;

import com.example.carRental.dto.RentalContractDTO;
import com.example.carRental.service.RentalContractService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rental")
public class RentalContractController {

    private RentalContractService rentalContractService;

    @PostMapping("/rent")
    public ResponseEntity<RentalContractDTO> rentVehicle (@RequestBody RentalContractDTO rentalContractDTO){
        RentalContractDTO rentedVehicle = rentalContractService.rentVehicle(rentalContractDTO);
        return new ResponseEntity<>(rentedVehicle, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RentalContractDTO>> showAllRentalContracts (){
        List<RentalContractDTO> rentalContracts = rentalContractService.showAllRentalContracts();
        return new ResponseEntity<>(rentalContracts, HttpStatus.OK);
    }
}
