package br.com.ecommerce;

import java.util.List;

public class InformacoesCarrinho{
    private List<Item> itens;
    private double precoTotal;

    public InformacoesCarrinho(List<Item> itens, double precoTotal) {
        this.itens = itens;
        this.precoTotal = precoTotal;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
}

