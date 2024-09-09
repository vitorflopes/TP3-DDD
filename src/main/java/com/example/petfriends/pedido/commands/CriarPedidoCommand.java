package com.example.petfriends.pedido.commands;

import java.util.Date;

public class CriarPedidoCommand extends BaseCommand<String> {

    public final String produto;
    public final double valor;
    public final String nomeCliente;

    public CriarPedidoCommand(String id, Date timestemp, String produto, double valor, String nomeCliente) {
        super(id, timestemp);
        this.produto = produto;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
    }
}
