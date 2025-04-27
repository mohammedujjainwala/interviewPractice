package parkinglot.payment.factory;

import parkinglot.enums.PaymentType;
import parkinglot.payment.IPaymentService;

public interface IPaymentFactory {
    IPaymentService getPaymentStrategy(PaymentType paymentType);
}
