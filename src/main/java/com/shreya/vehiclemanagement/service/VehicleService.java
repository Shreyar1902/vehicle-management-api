
package com.shreya.vehiclemanagement.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.shreya.vehiclemanagement.dto.VehicleRequest;
import com.shreya.vehiclemanagement.dto.VehicleResponse;
import com.shreya.vehiclemanagement.entity.Vehicle;
import com.shreya.vehiclemanagement.exception.ResourceNotFoundException;
import com.shreya.vehiclemanagement.repository.VehicleRepository;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Add a new vehicle
    public VehicleResponse addVehicle(VehicleRequest request) {

        if (vehicleRepository.existsByVehicleNumber(
                request.getVehicleNumber())) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Vehicle number already exists: "
                            + request.getVehicleNumber()
            );
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleName(request.getVehicleName());
        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setVehicleType(request.getVehicleType());
        vehicle.setBrand(request.getBrand());
        vehicle.setPrice(request.getPrice());
        vehicle.setStatus(request.getStatus());

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return convertToResponse(savedVehicle);
    }

    // Get all vehicles
    public List<VehicleResponse> getAllVehicles() {

        return vehicleRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get vehicle by ID
    public VehicleResponse getVehicleById(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vehicle not found with ID: " + id
                ));

        return convertToResponse(vehicle);
    }

    // Update vehicle
    public VehicleResponse updateVehicle(
            Long id, VehicleRequest request) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vehicle not found with ID: " + id
                ));

        if (vehicleRepository.existsByVehicleNumberAndIdNot(
                request.getVehicleNumber(), id)) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Vehicle number already exists: "
                            + request.getVehicleNumber()
            );
        }

        vehicle.setVehicleName(request.getVehicleName());
        vehicle.setVehicleNumber(request.getVehicleNumber());
        vehicle.setVehicleType(request.getVehicleType());
        vehicle.setBrand(request.getBrand());
        vehicle.setPrice(request.getPrice());
        vehicle.setStatus(request.getStatus());

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return convertToResponse(updatedVehicle);
    }

    // Delete vehicle
    public void deleteVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Vehicle not found with ID: " + id
                ));

        vehicleRepository.delete(vehicle);
    }

    // Convert entity to response DTO
    private VehicleResponse convertToResponse(Vehicle vehicle) {

        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getVehicleName(),
                vehicle.getVehicleNumber(),
                vehicle.getVehicleType(),
                vehicle.getBrand(),
                vehicle.getPrice(),
                vehicle.getStatus()
        );
    }
}
