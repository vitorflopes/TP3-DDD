package com.example.petfriends.pedido.events;


import java.util.Date;

public class PedidoCriado extends BaseEvent<String> {

    public final String produto;
    public final double valor;
    public final String nomeCliente;

    public PedidoCriado(String id, Date timestemp, String produto, double valor, String nomeCliente) {
        super(id, timestemp);
        this.produto = produto;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
    }
}
