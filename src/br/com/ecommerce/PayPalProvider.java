package br.com.ecommerce;

public class PayPalProvider implements PagamentoProvider {
    @Override
    public void processaPagamento (double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via PayPal.");
    }
}