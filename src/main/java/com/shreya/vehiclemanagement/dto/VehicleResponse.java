
package com.shreya.vehiclemanagement.dto;

public class VehicleResponse {

    private Long id;
    private String vehicleName;
    private String vehicleNumber;
    private String vehicleType;
    private String brand;
    private double price;
    private String status;

    public VehicleResponse(Long id, String vehicleName,
            String vehicleNumber, String vehicleType,
            String brand, double price, String status) {

        this.id = id;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
}
