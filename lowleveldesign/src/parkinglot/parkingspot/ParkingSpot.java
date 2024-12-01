package parkinglot.parkingspot;

import parkinglot.enums.ParkingSpotStatus;
import parkinglot.enums.ParkingSpotType;
import parkinglot.exceptions.ParkingSpotAlreadyFilled;
import parkinglot.models.Location;
import parkinglot.models.Vehicle;

public abstract class ParkingSpot {
    private String id;
    private Vehicle vehicle;
    private ParkingSpotStatus parkingSpotStatus;
    private Location location;

    public ParkingSpot(final String id, final Vehicle vehicle, final ParkingSpotStatus parkingSpotStatus,
                       final Location location) {
        this.id = id;
        this.vehicle = vehicle;
        this.parkingSpotStatus = parkingSpotStatus;
        this.location = location;
    }

    public abstract ParkingSpotType getType();
    public synchronized void parkVehicle(Vehicle vehicle){
        if(!isAvailable()){
            throw new ParkingSpotAlreadyFilled();
        }
        this.vehicle = vehicle;
        this.parkingSpotStatus = ParkingSpotStatus.FILLED;
    }

    public synchronized void removeVehicle(){
        this.parkingSpotStatus = ParkingSpotStatus.EMPTY;
        this.vehicle = null;
    }
    private boolean  isAvailable(){
        return ParkingSpotStatus.EMPTY.equals(parkingSpotStatus);
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public Location getLocation() {
        return location;
    }
}
