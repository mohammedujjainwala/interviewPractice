package parkinglot.parkingspot;

import parkinglot.enums.ParkingSpotStatus;
import parkinglot.enums.ParkingSpotType;
import parkinglot.models.Location;
import parkinglot.models.Vehicle;

public class FourWheelerParkingSpot extends ParkingSpot{
    public FourWheelerParkingSpot(final String id, final Vehicle vehicle,
                                  final ParkingSpotStatus parkingSpotStatus,
                                  final Location location) {
        super(id, vehicle, parkingSpotStatus, location);
    }

    @Override
    public ParkingSpotType getType() {
        return ParkingSpotType.FOUR_WHEELER_SPOT;
    }
}
