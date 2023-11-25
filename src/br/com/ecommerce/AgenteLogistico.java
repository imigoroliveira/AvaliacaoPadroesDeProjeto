package br.com.ecommerce;
import java.util.List;

	public class AgenteLogistico implements Observer {
	    private List<Item> produtosEmbarcados;

	    public void informarCompraConfirmada(double valor, List<Item> produtos) {
	        System.out.println("Compra confirmada!");
	        System.out.println("Itens a serem entregues:");
	        for (Item produto : produtos) {
	            produto.exibirInformacoes();
	        }
	        produtosEmbarcados = produtos;
	    }

	    public void informarCompraCancelada() {
	        System.out.println("Compra cancelada. Proceder à devolução dos produtos ou cancelar a ordem de transporte.");
	        produtosEmbarcados = null;
	    }

	    @Override
	    public void atualizar() {
	        if (produtosEmbarcados != null) {
	            System.out.println("Atualização do Agente Logístico: Itens em trânsito.");
	        } else {
	            System.out.println("Atualização do Agente Logístico: Nenhum item em trânsito.");
	        }
	    }
	}