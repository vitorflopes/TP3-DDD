package com.example.petfriends.pedido.service;

import com.example.petfriends.pedido.domain.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoQueryService {
    public Optional<Pedido> obterPorId(String id);
    public List<Object> listarEventos(String id);
}
