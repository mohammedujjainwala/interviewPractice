package parkinglot.parkingspot.operation;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.VehicleType;

public class ParkingSpotTypeVisitor implements ParkingSpotType.IParkingSpotTypeVisitor<VehicleType, Boolean>{

    @Override
    public Boolean visitTwoWheeler(VehicleType vehicleType) {
        return VehicleType.TWO_WHEELER.equals(vehicleType);
    }

    @Override
    public Boolean visitFourWheeler(VehicleType vehicleType) {
        return VehicleType.FOUR_WHEELER.equals(vehicleType);
    }

    @Override
    public Boolean visitNA(VehicleType vehicleType) {
        return true;
    }
}
