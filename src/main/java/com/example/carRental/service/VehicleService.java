package com.example.carRental.service;

import com.example.carRental.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> getAllVehicles();

    VehicleDTO getVehicleById(Long vehicleId);

    VehicleDTO updateVehicle(Long vehicleId, VehicleDTO vehicleDTO);

    void deleteVehicle(Long vehicleId);
}
