package parkinglot.parkingspot;

import parkinglot.enums.VehicleType;
import parkinglot.parkingstrategy.IParkingStrategy;

import java.util.Map;

public abstract class TwoWheelerParkingSpotManager extends ParkingSpotManager{


    public TwoWheelerParkingSpotManager(final Map<String, ParkingSpot> parkingSpot,
                                        final IParkingStrategy parkingStrategy,
                                        final ParkingSpotManager next) {
        super(parkingSpot, parkingStrategy, next);
    }

    public VehicleType getSupportedVehicleType(){
        return VehicleType.TWO_WHEELER;
    }
}
