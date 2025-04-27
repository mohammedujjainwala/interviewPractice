package parkinglot.enums;

public enum ParkingSpotType {
    TWO_WHEELER_SPOT {
        @Override
        public <T,K> K accept(IParkingSpotTypeVisitor<T,K> visitor, T t){
            return visitor.visitTwoWheeler(t);
        }
    }, FOUR_WHEELER_SPOT {
        @Override
        public <T,K> K accept(IParkingSpotTypeVisitor<T,K> visitor, T t){
            return visitor.visitFourWheeler(t);
        }
    },
    NA {
        @Override
        public <T,K> K accept(IParkingSpotTypeVisitor<T,K> visitor, T t){
            return visitor.visitNA(t);
        }
    };

    public abstract <T,K> K accept(IParkingSpotTypeVisitor<T, K> visitor, T t);

    public interface IParkingSpotTypeVisitor<T, K> {
        K visitTwoWheeler(T t);

        K visitFourWheeler(T t);

        K visitNA(T t);
    }

}
