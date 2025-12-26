package model;

public class Clothes extends Product {
    private String size;
    private String material;

    public Clothes(String type, String name, double price, String size, String material) {
        super(type, name, price);
        this.size = size;
        this.material = material;
    }

    @Override
    public String toString() {
        return String.format("%s | Tamanho: %-3s | Material: %s",
                super.toString(), size, material);
    }
}
