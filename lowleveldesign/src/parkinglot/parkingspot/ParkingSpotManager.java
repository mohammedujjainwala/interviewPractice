package parkinglot.parkingspot;

import parkinglot.enums.ParkingSpotType;
import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Vehicle;
import parkinglot.parkingspot.models.IParkingSpot;
import parkinglot.parkingspot.models.impl.ParkingSpot;
import parkinglot.parkingstrategy.IParkingStrategy;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

public class ParkingSpotManager implements IParkingSpotManager{
    private Map<String, IParkingSpot> parkingSpots;
    private IParkingStrategy parkingStrategy;
    private ParkingSpotType type;
    private IParkingSpotManager next;

    public ParkingSpotManager(Map<String, IParkingSpot> parkingSpots, IParkingStrategy parkingStrategy, ParkingSpotType type, IParkingSpotManager next) {
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
        this.type = type;
        this.next = next;
    }

    @Override
    public boolean isParkingSpotAvailable() {
        return parkingStrategy.hasAvailableSpot();
    }

    @Override
    public Optional<ParkingSpotInfo> parkVehicle(Vehicle vehicle, GateInfo gateInfo) {
        final Optional<String> parkingSpotId = parkingStrategy.nextParkingSpot(gateInfo);
        if(parkingSpotId.isEmpty()){
            return Optional.empty();
        }
        final IParkingSpot parKingSpot = parkingSpots.get(parkingSpotId.get());
        if(parKingSpot.parkVehicle(vehicle)){
            return Optional.of(new ParkingSpotInfo(parkingSpotId.get(), parKingSpot.getParkingSpotInfo().getParkingSpotType()
                    , parKingSpot.getParkingSpotInfo().getLocation()));
        }
        return Optional.empty();
    }

    @Override
    public void vacateVehicleFromSpot(String spotId) {
        final IParkingSpot parKingSpot = parkingSpots.get(spotId);
        parkingStrategy.addEmptyParkingSpot(parKingSpot.getParkingSpotInfo());
    }

    public ParkingSpotType getType() {
        return type;
    }

    public IParkingSpotManager getNext() {
        return next;
    }
}
