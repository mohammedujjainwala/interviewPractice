package parkinglot.payment.factory;

import parkinglot.enums.PaymentType;
import parkinglot.payment.CardPaymentService;
import parkinglot.payment.IPaymentService;
import parkinglot.payment.UPIPaymentService;

public class DefaultPaymentFactory implements IPaymentFactory{
    @Override
    public IPaymentService getPaymentStrategy(PaymentType paymentType) {
        return paymentType.accept(new PaymentType.PaymentTypeVisitor<IPaymentService>() {
            @Override
            public IPaymentService visitUpi() {
                return new UPIPaymentService();
            }

            @Override
            public IPaymentService visitCard() {
                return new CardPaymentService();
            }
        });
    }
}
