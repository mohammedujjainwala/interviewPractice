package parkinglot.exceptions;

public class ParkingSpotAlreadyFilled extends RuntimeException{
    public ParkingSpotAlreadyFilled(){
        super("Parking Spot Already Filled!!!");
    }
}