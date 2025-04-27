package parkinglot.parkingspot.operation;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.VehicleType;
import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;
import parkinglot.parkingspot.IParkingSpotManager;

import java.util.Optional;

public class ParkVehicleOperation extends ParkingOperation<Optional<ParkingSpotInfo>, VehicleType>{

    private final Vehicle vehicle;
    private GateInfo gateInfo;


    public ParkVehicleOperation(ParkingSpotType.IParkingSpotTypeVisitor<VehicleType, Boolean> parkingSpotTypeVisitor,
                                Vehicle vehicle) {
        super(parkingSpotTypeVisitor);
        this.vehicle = vehicle;

    }

    @Override
    protected Optional<ParkingSpotInfo> doOperation(IParkingSpotManager manager) {
        return manager.parkVehicle(vehicle, gateInfo);
    }
}
