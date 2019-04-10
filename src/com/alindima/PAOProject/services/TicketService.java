package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Ticket;

import java.util.ArrayList;

public class TicketService {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    private static TicketService instance = new TicketService();

    public static TicketService getInstance() {
        return instance;
    }

    private TicketService() {
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
