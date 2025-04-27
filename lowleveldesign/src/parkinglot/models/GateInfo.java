package parkinglot.models;

import parkinglot.enums.GateType;

public class GateInfo {
    private String id;
    private Location location;
    private GateType gateType;

    public GateInfo(String id, Location location, GateType gateType) {
        this.id = id;
        this.location = location;
        this.gateType = gateType;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public GateType getGateType() {
        return gateType;
    }
}
