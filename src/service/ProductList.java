package service;

import model.Clothes;
import model.Footwear;
import model.Perfume;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    private List<Footwear> footwearsList = new ArrayList<>();
    private List<Clothes> clothesList = new ArrayList<>();
    private List<Perfume> perfumesList = new ArrayList<>();

    public ProductList() {
        populateLists();
    }

    public void populateLists() {
        footwearsList.add(new Footwear("Calçados", "Tênis de Corrida", 179.99, "40", "Preto"));
        footwearsList.add(new Footwear("Calçados", "Sandália de Verão", 149.99, "34", "Marrom"));
        footwearsList.add(new Footwear("Calçados", "Bota de Couro", 249.99, "42", "Marrom"));

        clothesList.add(new Clothes("Roupas", "Camiseta Básica", 69.99, "M", "Algodão"));
        clothesList.add(new Clothes("Roupas", "Calça Jeans", 389.99, "38", "Jeans"));
        clothesList.add(new Clothes("Roupas", "Jaqueta de Couro", 1599.99, "G", "Couro"));

        perfumesList.add(new Perfume("Perfumes", "Eau de Parfum", 429.99, "50ml"));
        perfumesList.add(new Perfume("Perfumes", "Colônia Refrescante", 899.99, "100ml"));
        perfumesList.add(new Perfume("Perfumes", "Água de Cheiro", 199.99, "30ml"));
    }

    public void selectOptions(int option, Scanner scanner, Cart myCart) {
        List<? extends Product> selectedList;

        switch (option) {
            case 1 -> selectedList = footwearsList;
            case 2 -> selectedList = clothesList;
            case 3 -> selectedList = perfumesList;
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        if (selectedList.isEmpty()) {
            System.out.println("Não há produtos nesta categoria.");
            return;
        }

        System.out.println("\n--- Produtos Disponíveis ---");
        for (int i = 0; i < selectedList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, selectedList.get(i).toString());
        }

        System.out.print("\nDigite o número do produto para comprar ou 0 para voltar: ");

        if (scanner.hasNextInt()) {
            int productOption = scanner.nextInt();
            scanner.nextLine();

            if (productOption == 0) {
                return;
            }

            if (productOption >= 1 && productOption <= selectedList.size()) {
                Product chosenProduct = selectedList.get(productOption - 1);
                myCart.addProduct(chosenProduct);

                System.out.println("\nPressione ENTER para voltar ao menu principal...");
                scanner.nextLine();
            } else {
                System.out.println("Opção de produto inválida!");
            }
        } else {
            System.out.println("Entrada inválida! Digite um número.");
            scanner.next();
        }
    }
}