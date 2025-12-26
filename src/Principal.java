import service.Cart;
import service.ProductList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductList service = new ProductList();
        Cart myCart = new Cart();

        double balance = 1000.00;
        int menuOption = -1;

        while (menuOption != 0) {
            System.out.println("\n=========================================");
            System.out.printf(" SALDO DISPONÍVEL: R$ %.2f%n", balance);
            System.out.println("=========================================");
            System.out.println("1. Calçados");
            System.out.println("2. Roupas");
            System.out.println("3. Perfumes");
            System.out.println("4. Ver Carrinho / Finalizar Compra");
            System.out.println("5. Remover Item do Carrinho");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");

            if (scanner.hasNextInt()) {
                menuOption = scanner.nextInt();
                scanner.nextLine();

                switch (menuOption) {
                    case 1, 2, 3 -> service.selectOptions(menuOption, scanner, myCart);

                    case 4 -> {
                        myCart.showCart();
                        if (!myCart.isCartEmpty()) {
                            System.out.println("\n[1] Finalizar Compra | [ENTER] Voltar ao Menu");
                            String input = scanner.nextLine();

                            if (input.equals("1")) {
                                double total = myCart.getTotal();
                                if (total <= balance) {
                                    balance -= total;
                                    System.out.println("\n=========================================");
                                    System.out.println("COMPRA REALIZADA COM SUCESSO!");
                                    System.out.printf("Saldo restante: R$ %.2f%n", balance);
                                    System.out.println("=========================================");
                                    System.out.println("Encerrando a aplicação...");
                                    return;
                                } else {
                                    System.out.println("\nSALDO INSUFICIENTE!");
                                    System.out.println("Pressione Enter para voltar e remover itens.");
                                    scanner.nextLine();
                                }
                            }
                        } else {
                            System.out.println("Pressione Enter para voltar...");
                            scanner.nextLine();
                        }
                    }

                    case 5 -> {
                        if (myCart.isCartEmpty()) {
                            System.out.println("\nO carrinho está vazio. Nada para remover.");
                        } else {
                            myCart.removeProduct(scanner);
                        }
                        System.out.println("\nPressione Enter para continuar...");
                        scanner.nextLine();
                    }

                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Digite um número válido.");
                scanner.next();
            }
        }
    }
}