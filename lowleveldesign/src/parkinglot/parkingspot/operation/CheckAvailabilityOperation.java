package parkinglot.parkingspot.operation;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.VehicleType;
import parkinglot.parkingspot.IParkingSpotManager;

public class CheckAvailabilityOperation extends ParkingOperation<Boolean, VehicleType>{

    public CheckAvailabilityOperation(ParkingSpotType.IParkingSpotTypeVisitor<VehicleType, Boolean> parkingSpotTypeVisitor) {
        super(parkingSpotTypeVisitor);
    }

    @Override
    protected Boolean doOperation(IParkingSpotManager manager) {
        return manager.isParkingSpotAvailable();
    }
}
