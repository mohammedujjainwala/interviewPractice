package solid.openclosed.invalid;

import solid.singleresponsibility.valid.Invoice;

public class InvoiceDao {
    private Invoice invoice;


    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb(){
        // Save to DB
    }

    // new functionality
    public void savaToFile(){
        //Save to File
    }
}

//Later if I want to save it file then I will add another function and make changes in File. This is against
// OpenClosed Principle. We should not change already tested class.