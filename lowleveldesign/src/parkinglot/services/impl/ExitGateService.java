package parkinglot.services.impl;

import parkinglot.exceptions.GateIdExist;
import parkinglot.gate.IEntryGate;
import parkinglot.gate.IExitGate;
import parkinglot.models.GateInfo;
import parkinglot.services.IExitGateService;

import java.util.Map;

public class ExitGateService implements IExitGateService {

    private Map<String, IExitGate> exitGates;

    public ExitGateService(Map<String, IExitGate> exitgates) {
        this.exitGates = exitgates;
    }


    @Override
    public IExitGate getExitGate(String gateId) {
        return exitGates.get(gateId);
    }

    @Override
    public void addExitGate(IExitGate exitGate) {
        String gateId = exitGate.getInfo().getId();
        if(exitGates.containsKey(gateId)){
            throw new GateIdExist();
        }
        exitGates.put(gateId, exitGate);
    }

    @Override
    public void removeGate(String gateId) {
        exitGates.remove(gateId);
    }
}
