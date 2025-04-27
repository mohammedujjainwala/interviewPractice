package parkinglot.factory;

import parkinglot.enums.GateStatus;
import parkinglot.gate.IEntryGate;
import parkinglot.gate.impl.EntryGate;
import parkinglot.models.Location;
import parkinglot.services.IEntryGateService;
import parkinglot.services.IParkingSpotService;
import parkinglot.services.impl.EntryGateService;

import java.util.HashMap;
import java.util.Map;

public class EntryGateServiceFactory implements IEntryGateServiceFactory{
    @Override
    public IEntryGateService getDefaultParkingSpotService(IParkingSpotService parkingSpotService) {
        IEntryGate entryGate = new EntryGate("1",parkingSpotService,new Location(1,"A1"), GateStatus.OPEN);
        Map<String, IEntryGate>entryGates = new HashMap<>();
        entryGates.put("1",entryGate);
        return new EntryGateService(entryGates);
    }
}
