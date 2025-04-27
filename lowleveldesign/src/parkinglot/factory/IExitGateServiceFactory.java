package parkinglot.factory;

import parkinglot.services.IEntryGateService;
import parkinglot.services.IExitGateService;
import parkinglot.services.IParkingSpotService;

public interface IExitGateServiceFactory {
    IExitGateService getDefaultParkingSpotService(IParkingSpotService parkingSpotService);
}
