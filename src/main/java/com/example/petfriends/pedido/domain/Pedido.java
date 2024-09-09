package com.example.petfriends.pedido.domain;

import com.example.petfriends.pedido.commands.CriarPedidoCommand;
import com.example.petfriends.pedido.events.PedidoCriado;
import jakarta.persistence.Entity;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.data.annotation.Id;

import java.util.Date;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private Date timestemp;
    private String produto;
    private double valor;
    private String nomeCliente;
    private String estado;

    public Pedido() {}

    @CommandHandler
    public Pedido(CriarPedidoCommand command) {
        AggregateLifecycle.apply(new PedidoCriado(
                command.id,
                command.timestemp,
                command.produto,
                command.valor,
                command.nomeCliente
        ));
    }

    @EventSourcingHandler
    public void on(PedidoCriado event) {
        this.id = event.id;
        this.timestemp = event.timestamp;
        this.produto = event.produto;
        this.valor = event.valor;
        this.nomeCliente = event.nomeCliente;
        this.estado = String.valueOf(Estado.CRIADO);

        AggregateLifecycle.apply(new PedidoCriado(
                this.id,
                this.timestemp,
                this.produto,
                this.valor,
                this.nomeCliente
        ));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(Date timestemp) {
        this.timestemp = timestemp;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
