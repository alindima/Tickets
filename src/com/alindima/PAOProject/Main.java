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
        loadDataFromDatabase();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LandingPage landingPage = LandingPage.getLandingPage();
                landingPage.run();
            }
        });

        DBService dbService = DBService.getInstance();
        dbService.closeConnection();
    }

    private static void loadDataFromDatabase() {
        clientService.readDataFromDB();
        locationService.readDataFromDB();
        eventService.readDataFromDB();
        ticketService.readDataFromDB();
    }

    private static void loadDataFromFile() {
        clientService.readDataFromFile();
        locationService.readDataFromFile();
        eventService.readDataFromFile();
        ticketService.readDataFromFile();
    }
}
