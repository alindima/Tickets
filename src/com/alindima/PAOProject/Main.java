package com.alindima.PAOProject;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.models.Ticket;
import com.alindima.PAOProject.models.events.ConcertEvent;
import com.alindima.PAOProject.models.events.Event;
import com.alindima.PAOProject.models.events.TheaterEvent;
import com.alindima.PAOProject.services.ClientService;
import com.alindima.PAOProject.services.EventService;
import com.alindima.PAOProject.services.LocationService;
import com.alindima.PAOProject.services.TicketService;

import java.time.LocalDateTime;
import java.util.List;

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

        Event e2 = new ConcertEvent(location, "AAA", LocalDateTime.now());
        eventService.addEvent(e2);

        for (Event e : eventService.getAllEvents()) {
            System.out.print(e.getName() + " ");
        }

        System.out.println();

        List<Event> sortedEventsByName = eventService.getSortedEventsByName();

        for (Event e : sortedEventsByName) {
            System.out.print(e.getName() + " ");
        }

        System.out.println();

        //adauga client
        Client client = new Client("Alin Dima", "Bucharest");
        ClientService clientService = ClientService.getInstance();
        clientService.addClient(client);

        Client client2 = new Client("Staniea Alex", "Bucharest");
        Client client3 = new Client("Ivascu", "Oltenita");
        clientService.addClient(client2);
        clientService.addClient(client3);

        List<Client> l = clientService.getClientsByCity("Bucharest");

        for(Client c : clientService.getAllClients()) {
            System.out.print(c.getName() + " ");
        }

        System.out.println();

        List<Client> sortedClients = clientService.getSortedClientsByName();

        for(Client c : sortedClients) {
            System.out.print(c.getName() + " ");
        }

        System.out.println("");

        //emite bilet
        Ticket ticket = new Ticket(event, client);
        TicketService ticketService = TicketService.getInstance();
        ticketService.addTicket(ticket);

        System.out.println(eventService.getEventsByLocation(location).size());
    }
}
