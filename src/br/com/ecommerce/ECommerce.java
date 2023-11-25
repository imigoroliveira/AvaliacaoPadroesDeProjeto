package br.com.ecommerce;

import java.util.function.Consumer;

public class ECommerce implements Observer, Consumer<InformacoesCarrinho> {

    private CarrinhoDeCompras carrinho;
    private PagamentoProvider pagamentoProvider;

    public ECommerce(PagamentoProvider pagamentoProvider) {
        this.pagamentoProvider = pagamentoProvider;
        this.carrinho = new CarrinhoDeCompras();
        this.carrinho.addObserver(this);
    }

    public void adicionarItemAoCarrinho(Item item) {
        carrinho.adicionarItem(item);
    }

    @Override
    public void atualizar() {
        System.out.println("Carrinho de compras atualizado!");
    }

    @Override
    public void accept(InformacoesCarrinho informacoes) {
        // Lógica para tratar as informações do carrinho
        Double novoPreco = informacoes.getPrecoTotal();
        atualizarCarrinho(novoPreco);
    }

    private void atualizarCarrinho(Double novoPreco) {
        System.out.println("Carrinho atualizado! Novo total: R$" + novoPreco);
    }

    public void processaPedido(double valor) {
        System.out.println("Iniciando pedido....");
        pagamentoProvider.processaPagamento(valor);
        System.out.println("Pedido feito com sucesso.");
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }
}
