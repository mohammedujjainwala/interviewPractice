package parkinglot.services.impl;

import parkinglot.exceptions.GateIdExist;
import parkinglot.gate.IEntryGate;
import parkinglot.services.IEntryGateService;

import java.util.Map;

public class EntryGateService implements IEntryGateService {

    private final Map<String, IEntryGate> entryGates;

    public EntryGateService(Map<String, IEntryGate> entryGates) {
        this.entryGates = entryGates;
    }

    @Override
    public IEntryGate getEntryGate(String gateId) {
        return entryGates.get(gateId);
    }

    @Override
    public void addEntryGate(IEntryGate entryGate) {
        String gateId = entryGate.getInfo().getId();
        if(entryGates.containsKey(gateId)){
            throw new GateIdExist();
        }
        entryGates.put(gateId, entryGate);
    }

    @Override
    public void removeGate(String gateId) {
        entryGates.remove(gateId);
    }
}
