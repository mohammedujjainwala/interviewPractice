package parkinglot.exceptions;

public class PricingHandlerNotFound extends RuntimeException{
    public PricingHandlerNotFound(){
        super("Pricing handler not found!!!");
    }

}
