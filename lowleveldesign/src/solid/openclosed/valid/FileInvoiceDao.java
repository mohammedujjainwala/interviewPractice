package solid.openclosed.valid;

import solid.singleresponsibility.valid.Invoice;

public class FileInvoiceDao implements InvoiceDao{
    private Invoice invoice;


    public FileInvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save(){
        // Save to File
    }
}