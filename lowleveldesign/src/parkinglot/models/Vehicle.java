package parkinglot.models;

import parkinglot.enums.VehicleType;

public class Vehicle {
    private VehicleType vehicleType;
    private String vehicleNo;

    public Vehicle(final VehicleType vehicleType, final String vehicleNo) {
        this.vehicleType = vehicleType;
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }
}
