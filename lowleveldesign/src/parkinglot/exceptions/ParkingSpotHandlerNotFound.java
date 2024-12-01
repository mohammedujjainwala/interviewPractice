package parkinglot.exceptions;

public class ParkingSpotHandlerNotFound extends RuntimeException{
    public ParkingSpotHandlerNotFound(){
        super("Parking Spot Handler Not Found!!!");
    }
}
