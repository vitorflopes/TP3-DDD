package com.example.petfriends.pedido.service;

import com.example.petfriends.pedido.commands.CriarPedidoCommand;
import com.example.petfriends.pedido.domain.Pedido;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandServiceImpl implements PedidoComandService {

    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> criarPedido(Pedido pedido) {
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getTimestemp(),
                pedido.getProduto(),
                pedido.getValor(),
                pedido.getNomeCliente()
        ));
    }
}
