package br.com.ecommerce;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	PagamentoProvider pagamentoProvider = PagamentoProvider.createProvider("credit_card");
    	ECommerce ecommerce = new ECommerce(pagamentoProvider);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    // Adicionar produto ao carrinho
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o valor do produto: ");
                    double valorProduto = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha após o número
                    Item novoProduto = new Produto(nomeProduto, valorProduto);
                    ecommerce.adicionarItemAoCarrinho(novoProduto);
                    break;

                case 2:
                    ecommerce.getCarrinho().exibirInformacoes();
                    break;

                case 3:
                    // Fazer compra e fechar a compra
                    double totalDoCarrinho = ecommerce.getCarrinho().getPreco();
                    System.out.print("Total do carrinho: R$" + totalDoCarrinho);
                    System.out.print("\nConfirmar a compra? (S/N): ");
                    String confirmacao = scanner.nextLine().toUpperCase();
                    if (confirmacao.equals("S")) {
                        ecommerce.processaPedido(totalDoCarrinho);
                        ecommerce.getCarrinho().limparCarrinho();
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até logo!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n---- Menu ----");
        System.out.println("1. Adicionar produto ao carrinho");
        System.out.println("2. Visualizar carrinho");
        System.out.println("3. Fazer compra e fechar a compra");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
}
