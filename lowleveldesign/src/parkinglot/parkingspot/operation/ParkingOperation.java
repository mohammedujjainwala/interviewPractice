package parkinglot.parkingspot.operation;

import parkinglot.enums.ParkingSpotType;
import parkinglot.enums.VehicleType;
import parkinglot.parkingspot.IParkingSpotManager;

public abstract class ParkingOperation<T,K> {

    public ParkingSpotType.IParkingSpotTypeVisitor<K, Boolean> parkingSpotTypeVisitor;

    public ParkingOperation(ParkingSpotType.IParkingSpotTypeVisitor<K, Boolean> parkingSpotTypeVisitor) {
        this.parkingSpotTypeVisitor = parkingSpotTypeVisitor;
    }

    public T execute(IParkingSpotManager managerChain, K k) {
        if (managerChain.getType().accept(parkingSpotTypeVisitor, k)) {
            return doOperation(managerChain);
        }
        return this.execute(managerChain.getNext(),k);
    }

    protected abstract T doOperation(IParkingSpotManager manager);
}
