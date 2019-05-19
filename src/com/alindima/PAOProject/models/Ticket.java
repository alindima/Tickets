package com.alindima.PAOProject.models;

import com.alindima.PAOProject.models.events.Event;

import java.io.Serializable;

public class Ticket implements Serializable {
    private Event event;
    private Client client;
    private Integer id;

    public Ticket(Integer id, Event event, Client client) {
        this.id = id;
        this.event = event;
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return id;
    }
}
