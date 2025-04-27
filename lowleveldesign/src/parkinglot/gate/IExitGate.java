package parkinglot.gate;

import parkinglot.enums.PaymentType;
import parkinglot.models.ParkingSpotInfo;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;

public interface IExitGate extends IGate{
    double getPrice(Ticket ticket);
    boolean payment(PaymentType paymentType, double price);
    void vacateSpot(ParkingSpotInfo spotInfo);
}
