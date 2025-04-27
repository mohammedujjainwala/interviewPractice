package parkinglot.pricing.strategy;

import parkinglot.models.Ticket;

public class HourlyRate implements IPricingStrategy {

    private static final double HOURS_IN_MILLISECONDS=1000*60*60;

    @Override
    public double getCost(Ticket ticket,double rate) {
        long totalhours = (long)(Math.ceil(System.currentTimeMillis()-ticket.getEntryTime())/(double)HOURS_IN_MILLISECONDS);
        return totalhours==0?rate:rate*totalhours;
    }
}
