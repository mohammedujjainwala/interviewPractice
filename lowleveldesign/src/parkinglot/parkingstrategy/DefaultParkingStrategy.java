package parkinglot.parkingstrategy;

import parkinglot.models.GateInfo;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.parkingspot.models.IParkingSpot;
import parkinglot.parkingspot.models.impl.ParkingSpot;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class DefaultParkingStrategy implements IParkingStrategy {
    private List<Queue<String>> parkingSpotQueues; //based on floor

    public DefaultParkingStrategy(final List<Queue<String>> parkingSpotQueues) {
        this.parkingSpotQueues = parkingSpotQueues;
    }

    @Override
    public boolean hasAvailableSpot() {
        for(Queue<String> parkingSpotQueue: parkingSpotQueues){
            if(parkingSpotQueue.isEmpty()){
                continue;
            }
            return true;
        }
        return false;
    }

    @Override
    public synchronized Optional<String> nextParkingSpot(final GateInfo gateInfo) {
        for(Queue<String> parkingSpotQueue: parkingSpotQueues){
            if(parkingSpotQueue.isEmpty()){
                continue;
            }
            return Optional.of(parkingSpotQueue.poll());
        }
        return Optional.empty();
    }

    @Override
    public void addEmptyParkingSpot(final ParkingSpotInfo parkingSpot) {
        parkingSpotQueues.get(parkingSpot.getLocation().getFloorNo()-1).add(parkingSpot.getId());
    }
}
