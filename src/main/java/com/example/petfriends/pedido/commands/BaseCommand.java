package com.example.petfriends.pedido.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Date;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T id;
    public final Date timestemp;

    public BaseCommand(T id, Date timestemp) {
        this.id = id;
        this.timestemp = timestemp;
    }

}
