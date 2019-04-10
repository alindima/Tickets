package com.alindima.PAOProject;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.models.Ticket;
import com.alindima.PAOProject.models.events.Event;
import com.alindima.PAOProject.models.events.TheaterEvent;
import com.alindima.PAOProject.services.ClientService;
import com.alindima.PAOProject.services.EventService;
import com.alindima.PAOProject.services.LocationService;
import com.alindima.PAOProject.services.TicketService;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        //adauga locatie
        Location location = new Location("TNB", "Bucharest", "Romania");
        LocationService locationService = LocationService.getInstance();
        locationService.addLocation(location);

        //adauga event
        Event event = new TheaterEvent(location, "Dineu Cu Prosti", LocalDateTime.now());
        EventService eventService = EventService.getInstance();
        eventService.addEvent(event);

        //adauga client
        Client client = new Client("Alin Dima");
        ClientService clientService = ClientService.getInstance();
        clientService.addClient(client);
        System.out.println(client.getId());

        //emite bilet
        Ticket ticket = new Ticket(event, client);
        TicketService ticketService = TicketService.getInstance();
        ticketService.addTicket(ticket);
    }
}
