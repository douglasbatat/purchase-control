package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
        System.out.println("\n[" + product.getName() + "] adicionado ao carrinho!");
    }

    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("\n[ Carrinho Vazio ]");
            return;
        }

        System.out.println("\n--- SEU CARRINHO ---");
        for (int i = 0; i < items.size(); i++) {
             System.out.printf("[%d] %s%n", i + 1, items.get(i).toString());
        }
        System.out.println("------------------------------------------");
        System.out.printf("VALOR TOTAL: R$ %.2f%n", getTotal());
    }

    public void removeProduct(Scanner scanner) {
        if (items.isEmpty()) {
            System.out.println("\nO carrinho já está vazio.");
            return;
        }

        showCart();
        System.out.print("Escolha o número para remover ou 0 para voltar: ");

        if (scanner.hasNextInt()) {
            int index = scanner.nextInt();
            if (index > 0 && index <= items.size()) {
                Product removed = items.remove(index - 1);
                System.out.println("Item removido: " + removed.getName());
            }
        }
    }

    public boolean isCartEmpty() {
        return items.isEmpty();
    }
}