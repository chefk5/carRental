package com.example.carRental.mapper;

import com.example.carRental.dto.VehicleDTO;
import com.example.carRental.entity.Vehicle;
import lombok.Builder;

@Builder
public class VehicleMapper {

    public static VehicleDTO mapToVehicleDTO(Vehicle vehicle){
        return new VehicleDTO(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getYear(),
                vehicle.getColor(),
                vehicle.getRegistrationCode()
                );
    }

    public static Vehicle mapToVehicle(VehicleDTO vehicleDTO){
        return new Vehicle(
                vehicleDTO.getId(),
                vehicleDTO.getBrand(),
                vehicleDTO.getYear(),
                vehicleDTO.getColor(),
                vehicleDTO.getRegistrationCode()
        );
    }

}
