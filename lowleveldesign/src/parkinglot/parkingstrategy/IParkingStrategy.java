package parkinglot.parkingstrategy;

import parkinglot.parkingspot.ParkingSpot;

public interface IParkingStrategy {
    String nextParkingSpotId(int entryGateNo);
    void addEmptyParkingSpot(ParkingSpot parkingSpot);
}
