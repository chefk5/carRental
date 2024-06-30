package com.example.carRental.controller;


import com.example.carRental.dto.VehicleDTO;
import com.example.carRental.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle (@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO createdVehicle = vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> getAllVehicles(){
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable("id") Long vehicleId){
        VehicleDTO vehicleDTO = vehicleService.getVehicleById(vehicleId);
        return new ResponseEntity<>(vehicleDTO, HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable("id") Long vehicleId, @RequestBody VehicleDTO vehicleDTO){
        VehicleDTO updatedVehicle = vehicleService.updateVehicle(vehicleId, vehicleDTO);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable("id") Long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok("Vehicle deleted successfully");
    }
}
