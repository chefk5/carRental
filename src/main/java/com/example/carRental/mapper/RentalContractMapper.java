package com.example.carRental.mapper;

import com.example.carRental.dto.CustomerDto;
import com.example.carRental.dto.RentalContractDTO;
import com.example.carRental.entity.Customer;
import com.example.carRental.entity.RentalContract;

public class RentalContractMapper {


    public static RentalContractDTO mapToRentalContractDto(RentalContract rentalContract ) {
        return new RentalContractDTO(
                rentalContract.getId(),
                rentalContract.getCustomer(),
                rentalContract.getVehicle(),
                rentalContract.getStartDate(),
                rentalContract.getEndDate(),
                rentalContract.getRentalPrice(),
                rentalContract.getStatus()
                );
    }

    public static RentalContract mapToCustomer(RentalContractDTO rentalContractDTO) {
        return new RentalContract(
                rentalContractDTO.getId(),
                rentalContractDTO.getCustomer(),
                rentalContractDTO.getVehicle(),
                rentalContractDTO.getStartDate(),
                rentalContractDTO.getEndDate(),
                rentalContractDTO.getRentalPrice(),
                rentalContractDTO.getStatus()
        );
    }
}
