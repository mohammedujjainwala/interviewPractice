package parkinglot.factory;

import parkinglot.enums.GateStatus;
import parkinglot.enums.ParkingSpotType;
import parkinglot.gate.IExitGate;
import parkinglot.gate.impl.ExitGate;
import parkinglot.models.Location;
import parkinglot.payment.factory.DefaultPaymentFactory;
import parkinglot.pricing.OverflowPricing;
import parkinglot.pricing.Pricing;
import parkinglot.pricing.PricingImpl;
import parkinglot.pricing.strategy.HourlyRate;
import parkinglot.services.IExitGateService;
import parkinglot.services.IParkingSpotService;
import parkinglot.services.impl.ExitGateService;

import java.util.HashMap;
import java.util.Map;

public class ExitGateServiceFactory implements IExitGateServiceFactory{

    @Override
    public IExitGateService getDefaultParkingSpotService(IParkingSpotService parkingSpotService) {
        Pricing twoWheellerPricing = new PricingImpl(new OverflowPricing(null),new HourlyRate(),10, ParkingSpotType.TWO_WHEELER_SPOT);
        Pricing fourWheellerPricing = new PricingImpl(twoWheellerPricing,new HourlyRate(),20, ParkingSpotType.FOUR_WHEELER_SPOT);

        IExitGate exitGate = new ExitGate("1",new Location(1,"A1"),parkingSpotService, GateStatus.OPEN,
                fourWheellerPricing, new DefaultPaymentFactory());
        Map<String, IExitGate>exitGates = new HashMap<>();
        exitGates.put("1",exitGate);

        return new ExitGateService(exitGates);
    }
}
