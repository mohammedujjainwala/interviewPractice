package solid.openclosed.valid;

import solid.singleresponsibility.valid.Invoice;

public class DatabaseInvoiceDao implements InvoiceDao{
    private Invoice invoice;


    public DatabaseInvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save(){
        // Save to DB
    }
}