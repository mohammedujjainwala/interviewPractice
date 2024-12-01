package parkinglot.parkingstrategy;

import parkinglot.parkingspot.ParkingSpot;

import java.util.List;
import java.util.Queue;

public class DefaultParkingStrategy implements IParkingStrategy {
    List<Queue<String>> parkingSpotQueues;//based on floor
    public DefaultParkingStrategy(final List<Queue<String>> parkingSpotQueues) {
        this.parkingSpotQueues = parkingSpotQueues;
    }

    @Override
    public synchronized String nextParkingSpotId(final int entryGateNo) {
        for(Queue<String> parkingSpotQueue: parkingSpotQueues){
            if(parkingSpotQueue.isEmpty()){
                continue;
            }
            return parkingSpotQueue.poll();
        }
        return null;
    }

    @Override
    public void addEmptyParkingSpot(final ParkingSpot parkingSpot) {
        parkingSpotQueues.get(parkingSpot.getLocation().getFloorNo()).add(parkingSpot.getId());
    }
}
