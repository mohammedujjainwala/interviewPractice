package parkinglot.gate;

import parkinglot.enums.VehicleType;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;

public interface IEntryGate extends IGate{
    boolean parkingSpaceAvailable(VehicleType vehicleType);
    Ticket bookParkingSpot(Vehicle vehicle);
}
