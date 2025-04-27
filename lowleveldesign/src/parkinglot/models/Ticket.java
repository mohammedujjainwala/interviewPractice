package parkinglot.models;

public class Ticket {
    private Vehicle vehicle;
    private ParkingSpotInfo spot;
    private long entryTime;
    private String entryGateId;

    public Ticket(Vehicle vehicle, ParkingSpotInfo spot, long entryTime, String entryGateId) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = entryTime;
        this.entryGateId = entryGateId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpotInfo getSpot() {
        return spot;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public String getEntryGateId() {
        return entryGateId;
    }
}
