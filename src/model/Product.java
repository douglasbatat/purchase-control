package model;

public class Product {
    private String type;
    private String name;
    private double price;

    public Product(String tipo, String name, double price) {
        this.type = tipo;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
         return String.format("Categoria: %-9s | Nome do produto: %-20s | Preço: R$ %7.2f",
                type, name, price);
    }
}
