package parkinglot.exceptions;

public class FreeParkingSpotNotFound extends RuntimeException{
    public FreeParkingSpotNotFound(){
        super("No free parking spot found!!!");
    }
}
