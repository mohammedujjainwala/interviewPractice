package parkinglot.factory;

import parkinglot.services.IEntryGateService;
import parkinglot.services.IParkingSpotService;

public interface IEntryGateServiceFactory {
    IEntryGateService getDefaultParkingSpotService(IParkingSpotService parkingSpotService);
}
