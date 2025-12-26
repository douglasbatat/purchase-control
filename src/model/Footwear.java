package model;

public class Footwear extends Product {
    private String size;
    private String color;

    public Footwear(String type, String name, double price, String size, String color) {
        super(type, name, price);
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s | Tamanho: %-3s | Cor: %s",
                super.toString(), size, color);
    }
}
