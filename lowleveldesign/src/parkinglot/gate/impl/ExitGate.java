package parkinglot.gate.impl;

import parkinglot.enums.GateStatus;
import parkinglot.enums.GateType;
import parkinglot.enums.PaymentType;
import parkinglot.gate.IExitGate;
import parkinglot.models.*;
import parkinglot.payment.factory.IPaymentFactory;
import parkinglot.pricing.Pricing;
import parkinglot.services.IParkingSpotService;

public class ExitGate implements IExitGate {
    private String id;
    private Location location;
    private IParkingSpotService parkingSpotService;
    private GateStatus gateStatus;
    private Pricing pricing;
    private IPaymentFactory paymentFactory;

    public ExitGate(String id, Location location, IParkingSpotService parkingSpotService, GateStatus gateStatus, Pricing pricing, IPaymentFactory paymentFactory) {
        this.id = id;
        this.location = location;
        this.parkingSpotService = parkingSpotService;
        this.gateStatus = gateStatus;
        this.pricing = pricing;
        this.paymentFactory = paymentFactory;
    }

    @Override
    public double getPrice(Ticket ticket) {
        return pricing.evaluateCost(ticket);
    }

    @Override
    public boolean payment(PaymentType paymentType, double price) {
        return paymentFactory.getPaymentStrategy(paymentType).doPayment(price);
    }

    @Override
    public void vacateSpot(ParkingSpotInfo spotInfo) {
        parkingSpotService.vacateVehicleFromSpot(spotInfo);
    }

    @Override
    public GateInfo getInfo() {
        return new GateInfo(id,location, GateType.EXIT);
    }

    @Override
    public void updateStatus(GateStatus status) {
        this.gateStatus = status;
    }
}
