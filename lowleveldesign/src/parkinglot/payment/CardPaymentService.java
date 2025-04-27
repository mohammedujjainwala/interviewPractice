package parkinglot.payment;

public class CardPaymentService implements IPaymentService{
    @Override
    public boolean doPayment(double amount) {
        System.out.println("Doing Payment of amount:"+amount+" through Card");
        return true;
    }
}
