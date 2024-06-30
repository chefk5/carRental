package com.example.carRental.service.impl;

import com.example.carRental.dto.VehicleDTO;
import com.example.carRental.entity.Vehicle;
import com.example.carRental.exception.ResourceAlreadyExistsException;
import com.example.carRental.exception.ResourceNotFoundException;
import com.example.carRental.mapper.VehicleMapper;
import com.example.carRental.repository.CustomerRepository;
import com.example.carRental.repository.VehicleRepository;
import com.example.carRental.service.VehicleService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO){
        // check if customer exists

        Optional<Vehicle> duplicateVehicle = vehicleRepository.findByRegistrationCode(vehicleDTO.getRegistrationCode());

        // if customer exists throw error
        if(duplicateVehicle.isPresent()){
            throw new ResourceAlreadyExistsException("A vehicle already exists");
        }
        //if no customer exists, save it to DB
        Vehicle vehicle = VehicleMapper.mapToVehicle(vehicleDTO);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        //return created customer
        return VehicleMapper.mapToVehicleDTO(savedVehicle);

    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(VehicleMapper::mapToVehicleDTO).collect(Collectors.toList());
    }

    @Override
    public VehicleDTO getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new ResourceNotFoundException("Vehicle not found"));
        return VehicleMapper.mapToVehicleDTO(vehicle);
    }

    @Override
    public VehicleDTO updateVehicle(Long vehicleId, VehicleDTO updatedVehicle) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new ResourceNotFoundException("Vehicle not found"));
        vehicle.setBrand(updatedVehicle.getBrand());
        vehicle.setColor(updatedVehicle.getColor());
        vehicle.setYear(updatedVehicle.getYear());
        vehicle.setRegistrationCode(updatedVehicle.getRegistrationCode());

        Vehicle vehicleWithUpdatedProps = vehicleRepository.save(vehicle);
        return VehicleMapper.mapToVehicleDTO(vehicleWithUpdatedProps);

    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(()-> new ResourceNotFoundException("Vehicle not found"));
        vehicleRepository.delete(vehicle);
    }
}
