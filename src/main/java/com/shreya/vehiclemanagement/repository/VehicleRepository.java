package com.shreya.vehiclemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shreya.vehiclemanagement.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    boolean existsByVehicleNumber(String vehicleNumber);

    boolean existsByVehicleNumberAndIdNot(String vehicleNumber, Long id);
}