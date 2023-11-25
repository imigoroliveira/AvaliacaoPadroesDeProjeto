package br.com.ecommerce;

public class AgenteLogistico implements Observer {

    @Override
    public void atualizar() {
        System.out.println("Agente Logístico notificado sobre a atualização do carrinho.");
    }

    public void confirmarCompra() {
        System.out.println("Compra confirmada. Agente Logístico agendando a entrega.");
    }

    public void cancelarCompra() {
        System.out.println("Compra cancelada. Agente Logístico realizando devolução ou cancelando a entrega.");
    }
}
