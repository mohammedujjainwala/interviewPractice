package parkinglot.services.impl;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.VehicleType;
import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;
import parkinglot.parkingspot.IParkingSpotManager;
import parkinglot.parkingspot.operation.VacateSpotOperation;
import parkinglot.services.IParkingSpotService;
import parkinglot.parkingspot.operation.CheckAvailabilityOperation;
import parkinglot.parkingspot.operation.ParkVehicleOperation;
import parkinglot.parkingspot.operation.ParkingSpotTypeVisitor;

import java.util.Optional;

public class ParkingSpotService implements IParkingSpotService {

    private final IParkingSpotManager parkingSpotManager;

    public ParkingSpotService(IParkingSpotManager parkingSpotManager) {
        this.parkingSpotManager = parkingSpotManager;
    }

    @Override
    public boolean isParkingSpotAvailable(VehicleType vehicleType) {
        return new CheckAvailabilityOperation(new ParkingSpotTypeVisitor()).execute(parkingSpotManager, vehicleType);
    }

    @Override
    public Optional<ParkingSpotInfo> parkVehicle(Vehicle vehicle, GateInfo gateInfo) {
        return new ParkVehicleOperation(new ParkingSpotTypeVisitor(), vehicle)
                .execute(parkingSpotManager, vehicle.getVehicleType());
    }

    @Override
    public void vacateVehicleFromSpot(ParkingSpotInfo parkingSpotInfo) {
        new VacateSpotOperation(new ParkingSpotType.IParkingSpotTypeVisitor<ParkingSpotType, Boolean>() {
            @Override
            public Boolean visitTwoWheeler(ParkingSpotType parkingSpotType) {
                return ParkingSpotType.TWO_WHEELER_SPOT == parkingSpotType;
            }

            @Override
            public Boolean visitFourWheeler(ParkingSpotType parkingSpotType) {
                return ParkingSpotType.FOUR_WHEELER_SPOT == parkingSpotType;
            }

            @Override
            public Boolean visitNA(ParkingSpotType parkingSpotType) {
                return ParkingSpotType.NA == parkingSpotType;
            }
        }, parkingSpotInfo.getId()).execute(parkingSpotManager, parkingSpotInfo.getParkingSpotType());
    }
}
