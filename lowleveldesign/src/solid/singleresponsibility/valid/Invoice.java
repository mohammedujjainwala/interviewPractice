package solid.singleresponsibility.valid;

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

}
