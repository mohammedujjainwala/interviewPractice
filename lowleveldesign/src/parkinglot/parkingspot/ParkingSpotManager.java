package parkinglot.parkingspot;

import parkinglot.enums.VehicleType;
import parkinglot.exceptions.FreeParkingSpotNotFound;
import parkinglot.exceptions.ParkingSpotHandlerNotFound;
import parkinglot.models.Vehicle;
import parkinglot.parkingstrategy.IParkingStrategy;

import java.util.Map;

public abstract class ParkingSpotManager {
    private Map<String, ParkingSpot> parkingSpots;
    private IParkingStrategy parkingStrategy;
    private ParkingSpotManager next;

    public ParkingSpotManager(final Map<String, ParkingSpot> parkingSpots, final IParkingStrategy parkingStrategy,
                              final ParkingSpotManager next) {
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
        this.next = next;
    }

    public ParkingSpot findFreeParkingSpot(VehicleType vehicleType, int entryGateNo) {
        if(!canHandle(vehicleType)){
            return next.findFreeParkingSpot(vehicleType, entryGateNo);
        }
        String parkingSpotId = parkingStrategy.nextParkingSpotId(entryGateNo);
        if(parkingSpotId == null){
            throw new FreeParkingSpotNotFound();
        }
        return parkingSpots.get(parkingStrategy.nextParkingSpotId(entryGateNo));
    }


    public void parkVehicle(Vehicle vehicle, String spotId) {
        if(!canHandle(vehicle.getVehicleType())){
            next.parkVehicle(vehicle, spotId);
        }
        ParkingSpot parkingSpot = parkingSpots.get(spotId);
        parkingSpot.parkVehicle(vehicle);
    }

    public void vacateVehicleFromSpot(String spotId) {
        ParkingSpot parkingSpot = parkingSpots.get(spotId);
        if(!canHandle(parkingSpot.getVehicle().getVehicleType())){
            next.vacateVehicleFromSpot(spotId);
        }
        parkingSpot.removeVehicle();
        parkingStrategy.addEmptyParkingSpot(parkingSpots.get(spotId));
    }

    private boolean canHandle(VehicleType vehicleType){
        if(!vehicleType.equals(getSupportedVehicleType())){
            if(next == null){
                throw new ParkingSpotHandlerNotFound();
            }
        }
        return true;
    }

    public abstract VehicleType getSupportedVehicleType();
}
