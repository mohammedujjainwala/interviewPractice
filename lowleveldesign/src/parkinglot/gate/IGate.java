package parkinglot.gate;

import parkinglot.enums.GateStatus;
import parkinglot.models.GateInfo;

public interface IGate {
    GateInfo getInfo();
    void updateStatus(GateStatus status);
}
