package com.example.carRental.service.impl;

import com.example.carRental.Constants.RentalStatus;
import com.example.carRental.dto.RentalContractDTO;
import com.example.carRental.entity.RentalContract;
import com.example.carRental.exception.ResourceNotFoundException;
import com.example.carRental.mapper.RentalContractMapper;
import com.example.carRental.repository.RentalContractRepository;
import com.example.carRental.service.RentalContractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalContractServiceImpl implements RentalContractService {
    private RentalContractRepository rentalContractRepository;

    @Override
    public RentalContractDTO rentVehicle(RentalContractDTO rentalContractDTO) {
        Optional<RentalContract> optionalAvailableRentalContract = rentalContractRepository.checkIfVehicleIsRented(rentalContractDTO.getVehicle().getId());

        if (optionalAvailableRentalContract.isPresent()) {
            throw new ResourceNotFoundException("Vehicle is not available for rent");
        }

        // Get the available rental contract and update its status and dates
        RentalContract newRentalContract = new RentalContract();
        newRentalContract.setStatus(RentalStatus.RENTED);
        newRentalContract.setStartDate(rentalContractDTO.getStartDate());
        newRentalContract.setEndDate(rentalContractDTO.getEndDate());
        newRentalContract.setVehicle(rentalContractDTO.getVehicle());
        newRentalContract.setCustomer(rentalContractDTO.getCustomer());
        newRentalContract.setRentalPrice(rentalContractDTO.getRentalPrice());

        // Save the updated rental contract to the database
        RentalContract updatedRentalContract = rentalContractRepository.save(newRentalContract);

        // return rented vehicle
        return RentalContractMapper.mapToRentalContractDto(updatedRentalContract);
    }

    @Override
    public RentalContractDTO endRent(RentalContractDTO rentalContractDTO) {
        return null;
    }

    @Override
    public RentalContractDTO editRent(RentalContractDTO rentalContractDTO) {
        return null;
    }

    @Override
    public List<RentalContractDTO> showAllRentalContracts() {
        List<RentalContract> rentalContracts = rentalContractRepository.findAll();
        return rentalContracts.stream().map(RentalContractMapper::mapToRentalContractDto).collect(Collectors.toList());
    }
}
