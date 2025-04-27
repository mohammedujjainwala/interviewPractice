package parkinglot.gate.impl;

import parkinglot.enums.GateStatus;
import parkinglot.enums.GateType;
import parkinglot.enums.VehicleType;
import parkinglot.exceptions.FreeParkingSpotNotFound;
import parkinglot.gate.IEntryGate;
import parkinglot.models.*;
import parkinglot.services.IParkingSpotService;

import java.util.Optional;

public class EntryGate implements IEntryGate {

    private String id;
    private IParkingSpotService parkingSpotService;
    private Location location;
    private GateStatus gateStatus;

    public EntryGate(String id, IParkingSpotService parkingSpotService, Location location, GateStatus gateStatus) {
        this.id = id;
        this.parkingSpotService = parkingSpotService;
        this.location = location;
        this.gateStatus = gateStatus;
    }

    @Override
    public boolean parkingSpaceAvailable(VehicleType vehicleType) {
        return parkingSpotService.isParkingSpotAvailable(vehicleType);
    }

    @Override
    public Ticket bookParkingSpot(Vehicle vehicle) {
        Optional<ParkingSpotInfo> parkingSpotInfoOpt = parkingSpotService.parkVehicle(vehicle, getInfo());
        if(parkingSpotInfoOpt.isEmpty()){
            throw new FreeParkingSpotNotFound();
        }
        return new Ticket(vehicle,parkingSpotInfoOpt.get(),System.currentTimeMillis(),id);
    }

    @Override
    public GateInfo getInfo() {
        return new GateInfo(id,location, GateType.ENTRY);
    }

    @Override
    public void updateStatus(GateStatus status) {
        this.gateStatus = status;
    }
}
