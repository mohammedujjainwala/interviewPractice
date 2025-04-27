package parkinglot.services;

import parkinglot.gate.IExitGate;
import parkinglot.gate.IGate;
import parkinglot.gate.impl.ExitGate;

public interface IExitGateService extends IGateService {
    IExitGate getExitGate(String gateId);
    void addExitGate(IExitGate exitGate);
}
