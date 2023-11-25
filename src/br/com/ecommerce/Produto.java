package br.com.ecommerce;

public class Produto implements Item {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Produto: " + nome + ", Preço: R$" + preco);
    }
}