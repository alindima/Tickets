package com.alindima.PAOProject.models;

import com.alindima.PAOProject.models.events.Event;

public class Ticket {
    private Event event;
    private Client client;
    private Integer id;

    private static Integer nrTickets = 0;

    public Ticket(Event event, Client client) {
        this.event = event;
        this.client = client;
        this.id = ++nrTickets;
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
