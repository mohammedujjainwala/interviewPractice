package parkinglot.pricing;

import parkinglot.models.Ticket;

public abstract class Pricing {

    private Pricing next;

    public Pricing(Pricing next) {
        this.next = next;
    }

    protected double handle(Ticket ticket){
        return next.evaluateCost(ticket);
    }

    public abstract double evaluateCost(Ticket ticket);
}
