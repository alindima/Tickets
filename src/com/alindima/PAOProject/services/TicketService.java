package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.models.Ticket;

import java.util.ArrayList;

public class TicketService {

    private LogService logService = LogService.getInstance();

    private ArrayList<Ticket> tickets = new ArrayList<>();

    private static TicketService instance = new TicketService();

    private static FileSerializableService fileSerializableService = FileSerializableService.getInstance();

    public static TicketService getInstance() {
        return instance;
    }

    private TicketService() {
    }

    public void addTicket(Ticket ticket) {
        logService.writeLine("Add ticket");

        tickets.add(ticket);
    }

    public ArrayList<Ticket> getTicketsByClient(Client client) {
        logService.writeLine("Get tickets by client");

        ArrayList<Ticket> auxList = new ArrayList<>();

        for (Ticket t : tickets) {
            if (t.getClient().equals(client)) {
                auxList.add(t);
            }
        }

        return auxList;
    }

    public ArrayList<Ticket> getAllTickets() {
        logService.writeLine("Get all tickets");

        return tickets;
    }

    public void readDataFromFile(){
        tickets = (ArrayList<Ticket>) fileSerializableService.readObjectFromFile(fileSerializableService.getTicketSerializablePath());
    }

    public void writeDataToFile(){
        fileSerializableService.writeObjectToFile(tickets, fileSerializableService.getTicketSerializablePath());
    }
}
