package com.example.carRental.service;

import com.example.carRental.dto.RentalContractDTO;

import java.util.List;

public interface RentalContractService {
    RentalContractDTO rentVehicle(RentalContractDTO rentalContractDTO);
    
    

    RentalContractDTO endRent(RentalContractDTO rentalContractDTO);

    RentalContractDTO editRent(RentalContractDTO rentalContractDTO);

    List<RentalContractDTO> showAllRentalContracts();
}
