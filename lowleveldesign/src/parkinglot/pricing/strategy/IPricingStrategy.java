package parkinglot.pricing.strategy;

import parkinglot.models.Ticket;

public interface IPricingStrategy {
    double getCost(Ticket ticket, double rate);
}
