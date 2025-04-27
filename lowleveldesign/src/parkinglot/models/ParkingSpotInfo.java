package parkinglot.models;

import parkinglot.enums.ParkingSpotType;

public class ParkingSpotInfo {
    private String id;
    private ParkingSpotType parkingSpotType;
    private Location location;

    public ParkingSpotInfo(String id, ParkingSpotType parkingSpotType, Location location) {
        this.id = id;
        this.parkingSpotType = parkingSpotType;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public Location getLocation() {
        return location;
    }
}
