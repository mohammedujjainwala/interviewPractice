package parkinglot.services;

import parkinglot.gate.IEntryGate;

public interface IEntryGateService extends IGateService{
    IEntryGate getEntryGate(String gateId);
    void addEntryGate(IEntryGate entryGate);
}
