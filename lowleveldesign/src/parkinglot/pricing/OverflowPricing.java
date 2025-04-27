package parkinglot.pricing;

import parkinglot.exceptions.PricingHandlerNotFound;
import parkinglot.models.Ticket;

public class OverflowPricing extends Pricing{
    public OverflowPricing(Pricing next) {
        super(next);
    }

    @Override
    public double evaluateCost(Ticket ticket) {
        throw new PricingHandlerNotFound();
    }
}
