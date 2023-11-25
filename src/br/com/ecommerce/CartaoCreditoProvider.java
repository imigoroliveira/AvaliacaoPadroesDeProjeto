package br.com.ecommerce;

public class CartaoCreditoProvider implements PagamentoProvider {
    @Override
    public void processaPagamento(double amount) {
        System.out.println("Processando pagamento de R$" + amount + " via cartão de crédito.");
    }
}