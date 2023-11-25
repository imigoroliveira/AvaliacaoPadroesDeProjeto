package br.com.ecommerce;

public class Servico implements Item {
 private String nome;
 private double preco;

 public Servico(String nome, double preco) {
     this.nome = nome;
     this.preco = preco;
 }

 @Override
 public double getPreco() {
     return preco;
 }

 @Override
 public void exibirInformacoes() {
     System.out.println("Serviço: " + nome + ", Preço: R$" + preco);
 }
}
