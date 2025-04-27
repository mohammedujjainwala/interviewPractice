package parkinglot.services;

import parkinglot.enums.VehicleType;
import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;

import java.util.Optional;

public interface IParkingSpotService {

    boolean isParkingSpotAvailable(VehicleType vehicleType);
    Optional<ParkingSpotInfo> parkVehicle(Vehicle vehicle, GateInfo gateInfo);
    void vacateVehicleFromSpot(ParkingSpotInfo parkingSpotInfo);
}
