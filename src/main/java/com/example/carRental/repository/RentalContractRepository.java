package com.example.carRental.repository;

import com.example.carRental.Constants.RentalStatus;
import com.example.carRental.entity.RentalContract;
import com.example.carRental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RentalContractRepository extends JpaRepository<RentalContract, Long> {

    @Query("SELECT rc FROM RentalContract rc WHERE rc.status = RENTED AND rc.vehicle.id = :vehicleId")
    Optional<RentalContract> checkIfVehicleIsRented(@Param("vehicleId") Long vehicleId);

}
