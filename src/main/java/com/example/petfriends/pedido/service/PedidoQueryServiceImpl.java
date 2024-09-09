package com.example.petfriends.pedido.service;

import com.example.petfriends.pedido.domain.Pedido;
import com.example.petfriends.pedido.infra.PedidoRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {

    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    public PedidoQueryServiceImpl(EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    public Optional<Pedido> obterPorId(String id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Object> listarEventos(String id) {
        List<Object> retorno = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());

        return retorno;
    }
}
