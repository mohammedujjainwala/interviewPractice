package parkinglot.payment;

public class UPIPaymentService implements IPaymentService{
    @Override
    public boolean doPayment(double amount) {
        System.out.println("Doing Payment of amount:"+amount+" through UPI");
        return true;
    }
}
