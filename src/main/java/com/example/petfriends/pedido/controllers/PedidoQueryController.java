package com.example.petfriends.pedido.controllers;

import com.example.petfriends.pedido.domain.Pedido;
import com.example.petfriends.pedido.service.PedidoQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService service;

    public PedidoQueryController(PedidoQueryService service) {
        this.service = service;
    }

    @GetMapping("/{id}/pedidos")
    public List<Object> listarEventos(@PathVariable(value = "id") String id) {
        return service.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido obterPorId(@PathVariable(value = "id") String id){
        return service.obterPorId(id).get();
    }
}
