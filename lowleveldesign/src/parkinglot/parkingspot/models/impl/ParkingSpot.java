package parkinglot.parkingspot.models.impl;

import parkinglot.enums.ParkingSpotStatus;
import parkinglot.enums.ParkingSpotType;
import parkinglot.exceptions.ParkingSpotAlreadyFilled;
import parkinglot.models.Location;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;
import parkinglot.parkingspot.models.IParkingSpot;

public class ParkingSpot implements IParkingSpot {
    private final String id;
    private ParkingSpotStatus status;
    private Vehicle vehicle;
    private final Location location;
    private ParkingSpotType parkingSpotType;

    public ParkingSpot(String id, ParkingSpotStatus status,Location location, ParkingSpotType parkingSpotType) {
        this.id = id;
        this.status = status;
        this.location = location;
        this.parkingSpotType = parkingSpotType;
    }


    public ParkingSpotInfo getParkingSpotInfo(){
        return new ParkingSpotInfo(id, parkingSpotType, location);
    }
    
    public synchronized boolean parkVehicle(Vehicle vehicle){
        if(!isAvailable()){
            return false;
        }
        this.vehicle = vehicle;
        this.status = ParkingSpotStatus.FILLED;
        return true;
    }

    public synchronized void vacateVehicle(){
        this.status = ParkingSpotStatus.EMPTY;
        this.vehicle = null;
    }
    public boolean isAvailable(){
        return ParkingSpotStatus.EMPTY.equals(status);
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return status;
    }

    public Location getLocation() {
        return location;
    }
}
