package solid.singleresponsibility.valid;

public class InvoicePrinter {
    private Invoice invoice;


    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice(){
        // Print Invoice
    }
}
