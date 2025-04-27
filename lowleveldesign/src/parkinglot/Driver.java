package parkinglot;

import parkinglot.enums.PaymentType;
import parkinglot.enums.VehicleType;
import parkinglot.factory.*;
import parkinglot.gate.IEntryGate;
import parkinglot.gate.IExitGate;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.services.IEntryGateService;
import parkinglot.services.IExitGateService;
import parkinglot.services.IParkingSpotService;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        IParkingSpotServiceFactory parkingSpotServiceFactory = new ParkingSpotServiceFactory();
        IParkingSpotService parkingSpotService = parkingSpotServiceFactory.getDefaultParkingSpotService();

        IEntryGateService entryGateService = new EntryGateServiceFactory().getDefaultParkingSpotService(parkingSpotService);
        IExitGateService exitGateService = new ExitGateServiceFactory().getDefaultParkingSpotService(parkingSpotService);

        IEntryGate entryGate = entryGateService.getEntryGate("1");
        IExitGate exitGate = exitGateService.getExitGate("1");
        System.out.println("Two wheeler Parking Space Available : "+entryGate.parkingSpaceAvailable(VehicleType.TWO_WHEELER));
        if(entryGate.parkingSpaceAvailable(VehicleType.TWO_WHEELER)){
            Ticket ticket = entryGate.bookParkingSpot(new Vehicle(VehicleType.TWO_WHEELER,"123456"));
            System.out.println("Two wheeler Parking Space Available After booking : "+entryGate.parkingSpaceAvailable(VehicleType.TWO_WHEELER));
            System.out.println("Four wheeler Parking Space Available : "+entryGate.parkingSpaceAvailable(VehicleType.FOUR_WHEELER));
            Thread.sleep(1000);
            double price = exitGate.getPrice(ticket);
            System.out.println("Two wheeler park price : "+price);
            exitGate.payment(PaymentType.UPI, price);
            exitGate.vacateSpot(ticket.getSpot());
            System.out.println("Two wheeler Parking Space Available after exit : "+entryGate.parkingSpaceAvailable(VehicleType.TWO_WHEELER));
        }
    }
}
