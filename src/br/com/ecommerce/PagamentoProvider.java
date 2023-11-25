package br.com.ecommerce;

public interface PagamentoProvider {
    void processaPagamento(double valor);

    static PagamentoProvider createProvider(String providerType) {
        if (providerType.equals("credit_card")) {
            return new CartaoCreditoProvider();
        } else if (providerType.equals("paypal")) {
            return new PayPalProvider();
        } else {
            throw new IllegalArgumentException("Tipo de pagamento não suportado.");
        }
    }
}