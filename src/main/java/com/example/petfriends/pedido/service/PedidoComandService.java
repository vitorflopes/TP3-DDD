package com.example.petfriends.pedido.service;

import com.example.petfriends.pedido.domain.Pedido;

import java.util.concurrent.CompletableFuture;

public interface PedidoComandService {
    public CompletableFuture<String> criarPedido(Pedido pedido);
}
