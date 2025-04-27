package solid.singleresponsibility.invalid;

import solid.singleresponsibility.Marker;

public class Invoice {
    private Marker marker;
    private int quantity;


    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotalPrice(){
        return marker.getPrice()*quantity;
    }

    public void printInvoice(){
        //print Invoice
    }

    public void saveToDb(){
        //print Invoice
    }
}
//Since class has multiple reasons to change like change in calculateTotalPrice or the way printing invoice or saving
// it to DB it is not following Single Responsibility
