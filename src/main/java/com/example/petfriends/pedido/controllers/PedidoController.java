package com.example.petfriends.pedido.controllers;

import com.example.petfriends.pedido.domain.Pedido;
import com.example.petfriends.pedido.service.PedidoComandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    private final PedidoComandService service;

    public PedidoController(PedidoComandService service) {
        this.service = service;
    }

    @PostMapping
    public CompletableFuture<String> criarPedido(@RequestBody Pedido pedido) {
        return this.service.criarPedido(pedido);
    }
}
