package parkinglot.parkingspot.models;

import parkinglot.enums.ParkingSpotType;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;

public interface IParkingSpot {
    ParkingSpotInfo getParkingSpotInfo();
    boolean parkVehicle(Vehicle vehicle);
    void vacateVehicle();
    boolean isAvailable();
}
