package model;

public class Perfume extends Product {
    private String volume;

    public Perfume(String type, String name, double price, String volume) {
        super(type, name, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("%s | Volume: %s",
                super.toString(), volume);
    }
}
