package parkinglot.parkingstrategy;

import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.parkingspot.models.impl.ParkingSpot;

import java.util.Optional;

public interface IParkingStrategy {
    boolean hasAvailableSpot();
    Optional<String> nextParkingSpot(GateInfo gateInfo);
    void addEmptyParkingSpot(ParkingSpotInfo parkingSpot);
}
