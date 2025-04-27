package parkinglot.pricing;

import parkinglot.enums.ParkingSpotType;
import parkinglot.models.Ticket;
import parkinglot.pricing.strategy.IPricingStrategy;

public class PricingImpl extends Pricing{

    private IPricingStrategy pricingStrategy;
    private double rate;
    private ParkingSpotType type;

    public PricingImpl(Pricing next, IPricingStrategy pricingStrategy, double rate, ParkingSpotType type) {
        super(next);
        this.pricingStrategy = pricingStrategy;
        this.rate = rate;
        this.type = type;
    }


    @Override
    public double evaluateCost(Ticket ticket) {
        if(ticket.getSpot().getParkingSpotType() != type){
            return super.handle(ticket);
        }
        return pricingStrategy.getCost(ticket, rate);
    }
}
