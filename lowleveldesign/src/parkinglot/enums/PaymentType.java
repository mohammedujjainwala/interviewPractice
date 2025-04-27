package parkinglot.enums;

public enum PaymentType {
    UPI {
        @Override
        public <T> T accept(PaymentTypeVisitor<T> visitor) {
            return visitor.visitUpi();
        }
    }, CARD {
        @Override
        public <T> T accept(PaymentTypeVisitor<T> visitor) {
            return visitor.visitCard();
        }
    };

    public abstract <T> T accept(PaymentTypeVisitor<T> visitor);

    public interface PaymentTypeVisitor<T>{
        T visitUpi();
        T visitCard();
    }
}
