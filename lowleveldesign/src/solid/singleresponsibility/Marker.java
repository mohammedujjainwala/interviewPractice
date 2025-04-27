package solid.singleresponsibility;

public class Marker {
    private int price;
    private String color;
    private String name;

    public Marker(int price, String color, String name) {
        this.price = price;
        this.color = color;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
}
