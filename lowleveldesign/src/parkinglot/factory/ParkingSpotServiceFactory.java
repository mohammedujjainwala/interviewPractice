package parkinglot.factory;

import parkinglot.enums.ParkingSpotStatus;
import parkinglot.enums.ParkingSpotType;
import parkinglot.models.Location;
import parkinglot.parkingspot.IParkingSpotManager;
import parkinglot.parkingspot.ParkingSpotManager;
import parkinglot.parkingspot.ParkingSpotOverFlowManager;
import parkinglot.parkingspot.models.IParkingSpot;
import parkinglot.parkingspot.models.impl.ParkingSpot;
import parkinglot.parkingstrategy.DefaultParkingStrategy;
import parkinglot.services.IParkingSpotService;
import parkinglot.services.impl.ParkingSpotService;

import java.util.*;

public class ParkingSpotServiceFactory implements IParkingSpotServiceFactory{
    @Override
    public IParkingSpotService getDefaultParkingSpotService() {
        Map<String, IParkingSpot> fourWheeler = new HashMap<>();
        fourWheeler.put("2",new ParkingSpot("2", ParkingSpotStatus.EMPTY,new Location(1,"A1"), ParkingSpotType.FOUR_WHEELER_SPOT));
        final List<Queue<String>> fourWheelerParkingSpotQueues = new ArrayList<>();
        fourWheelerParkingSpotQueues.add(new LinkedList<>());
        fourWheelerParkingSpotQueues.get(0).add("2");
        IParkingSpotManager fourWheelerParkingSpotManager =  new ParkingSpotManager(fourWheeler, new DefaultParkingStrategy(fourWheelerParkingSpotQueues),
                ParkingSpotType.FOUR_WHEELER_SPOT,new ParkingSpotOverFlowManager());



        Map<String, IParkingSpot> twoWheeler = new HashMap<>();
        twoWheeler.put("1",new ParkingSpot("1", ParkingSpotStatus.EMPTY,new Location(1,"A1"), ParkingSpotType.TWO_WHEELER_SPOT));
        final List<Queue<String>> twoWheelerParkingSpotQueues = new ArrayList<>();
        twoWheelerParkingSpotQueues.add(new LinkedList<>());
        twoWheelerParkingSpotQueues.get(0).add("1");
        IParkingSpotManager twoWheelerParkingSpotManager =  new ParkingSpotManager(twoWheeler, new DefaultParkingStrategy(twoWheelerParkingSpotQueues),
                ParkingSpotType.TWO_WHEELER_SPOT,fourWheelerParkingSpotManager);
        return new ParkingSpotService(twoWheelerParkingSpotManager);
    }

    @Override
    public IParkingSpotService getEntryDistanceOptimisedParkingSpotService() {
        return null;
    }
}
