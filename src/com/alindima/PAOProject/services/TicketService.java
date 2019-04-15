package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.models.Ticket;

import java.util.ArrayList;
import java.util.List;

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

    public List<Ticket> getTicketsByClient(Client client) {
        ArrayList<Ticket> auxList = new ArrayList<>();

        for (Ticket t : tickets) {
            if (t.getClient().equals(client)) {
                auxList.add(t);
            }
        }

        return auxList;
    }
}
