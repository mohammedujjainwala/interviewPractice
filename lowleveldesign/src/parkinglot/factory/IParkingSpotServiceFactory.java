package parkinglot.factory;

import parkinglot.services.IParkingSpotService;

public interface IParkingSpotServiceFactory {
    IParkingSpotService getDefaultParkingSpotService();
    IParkingSpotService getEntryDistanceOptimisedParkingSpotService();
}
