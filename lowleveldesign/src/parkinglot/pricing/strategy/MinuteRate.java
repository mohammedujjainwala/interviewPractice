package parkinglot.pricing.strategy;

import parkinglot.models.Ticket;

public class MinuteRate implements IPricingStrategy{

    private static final long MINUTES_IN_MILLISECONDS=1000*60;

    @Override
    public double getCost(Ticket ticket, double rate) {
        long totalminutes = (long)(Math.ceil(System.currentTimeMillis()-ticket.getEntryTime())/(double)MINUTES_IN_MILLISECONDS);
        return totalminutes==0?rate:rate*totalminutes;
    }
}
