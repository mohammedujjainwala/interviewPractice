package parkinglot.parkingspot;

import parkinglot.enums.ParkingSpotType;
import parkinglot.exceptions.ParkingSpotHandlerNotFound;
import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;

import java.util.Optional;

public class ParkingSpotOverFlowManager implements IParkingSpotManager{

    @Override
    public boolean isParkingSpotAvailable() {
        return false;
    }

    @Override
    public Optional<ParkingSpotInfo> parkVehicle(Vehicle vehicle, GateInfo gateInfo) {
        return Optional.empty();
    }

    @Override
    public void vacateVehicleFromSpot(String spotId) {
        throw new ParkingSpotHandlerNotFound();
    }

    @Override
    public IParkingSpotManager getNext() {
        return this;
    }

    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.NA;
    }
}
