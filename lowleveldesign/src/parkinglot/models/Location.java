package parkinglot.models;

public class Location {
    int floorNo;
    String zone;

    public Location(final int floorNo, final String zone) {
        this.floorNo = floorNo;
        this.zone = zone;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public String getZone() {
        return zone;
    }
}
