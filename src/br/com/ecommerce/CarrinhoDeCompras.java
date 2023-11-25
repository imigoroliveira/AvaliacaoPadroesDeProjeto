package br.com.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CarrinhoDeCompras implements Item {
    private List<Item> itens;
    private List<Consumer<InformacoesCarrinho>> observers; 
    
    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        notificarObservers();
    }

    @Override
    public double getPreco() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Carrinho de Compras:");
        for (Item item : itens) {
            item.exibirInformacoes();
        }
        System.out.println("Total: R$" + getPreco());
    }

    public void addObserver(Consumer<InformacoesCarrinho> observer) {
        observers.add(observer);
    }

    public void removeObserver(Consumer<InformacoesCarrinho> observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {
        InformacoesCarrinho informacoes = new InformacoesCarrinho(itens, getPreco());
        observers.forEach(observer -> observer.accept(informacoes));
    }
    
    public void limparCarrinho() {
        this.itens.clear();
        notificarObservers();
    }
}
