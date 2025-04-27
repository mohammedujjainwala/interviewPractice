package parkinglot.parkingspot;

import parkinglot.enums.ParkingSpotType;
import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;

import java.util.Optional;

public interface IParkingSpotManager {
    boolean isParkingSpotAvailable();
    Optional<ParkingSpotInfo> parkVehicle(Vehicle vehicle, GateInfo gateInfo);
    void vacateVehicleFromSpot(String spotId);
    IParkingSpotManager getNext();
    ParkingSpotType getType();
}
