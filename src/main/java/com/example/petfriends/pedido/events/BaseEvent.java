package com.example.petfriends.pedido.events;

import java.util.Date;

public class BaseEvent<T> {

    public final T id;
    public final Date timestamp;

    public BaseEvent(T id, Date timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}
