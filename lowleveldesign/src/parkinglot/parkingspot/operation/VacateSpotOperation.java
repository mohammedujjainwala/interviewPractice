package parkinglot.parkingspot.operation;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.VehicleType;
import parkinglot.parkingspot.IParkingSpotManager;

public class VacateSpotOperation extends  ParkingOperation<Void, ParkingSpotType>{
    private String parkingSpotId;

    public VacateSpotOperation(ParkingSpotType.IParkingSpotTypeVisitor<ParkingSpotType, Boolean> parkingSpotTypeVisitor, String parkingSpotId) {
        super(parkingSpotTypeVisitor);
        this.parkingSpotId = parkingSpotId;
    }

    @Override
    protected Void doOperation(IParkingSpotManager manager) {
        manager.vacateVehicleFromSpot(parkingSpotId);
        return null;
    }
}
