package com.alindima.PAOProject;

import com.alindima.PAOProject.services.*;

public class Main {

    private static FileSerializableService fileSerializableService = FileSerializableService.getInstance();

    private static LocationService locationService = LocationService.getInstance();
    private static EventService eventService = EventService.getInstance();
    private static ClientService clientService = ClientService.getInstance();
    private static TicketService ticketService = TicketService.getInstance();

    public static void main(String[] args) {
//        fileSerializableService.populateDummyData();

        clientService.readDataFromFile();
        locationService.readDataFromFile();
        eventService.readDataFromFile();
        ticketService.readDataFromFile();

        System.out.println(clientService.getAllClients().size());
        System.out.println(locationService.getAllLocations().size());
        System.out.println(eventService.getAllEvents().size());
        System.out.println(ticketService.getAllTickets().size());

        clientService.writeDataToFile();
        locationService.writeDataToFile();
        eventService.writeDataToFile();
        ticketService.writeDataToFile();


    }
}
