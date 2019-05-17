package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.models.Ticket;
import com.alindima.PAOProject.models.events.ConcertEvent;
import com.alindima.PAOProject.models.events.Event;
import com.alindima.PAOProject.models.events.TheaterEvent;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class FileSerializableService {
    private static FileSerializableService ourInstance = new FileSerializableService();

    private String clientSerializablePath = "C:\\Users\\alin\\IdeaProjects\\tickets\\resources\\clients.txt";
    private String eventSerializablePath = "C:\\Users\\alin\\IdeaProjects\\tickets\\resources\\events.txt";
    private String locationSerializablePath = "C:\\Users\\alin\\IdeaProjects\\tickets\\resources\\locations.txt";
    private String ticketSerializablePath = "C:\\Users\\alin\\IdeaProjects\\tickets\\resources\\tickets.txt";

    public static FileSerializableService getInstance() {
        return ourInstance;
    }

    private FileSerializableService() {
    }

    public void writeObjectToFile(Object object, String path) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(object);

            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readObjectFromFile(String path) {
        Object object = null;

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            object = objectInputStream.readObject();

            objectInputStream.close();

        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    public String getClientSerializablePath() {
        return clientSerializablePath;
    }

    public String getEventSerializablePath() {
        return eventSerializablePath;
    }

    public String getLocationSerializablePath() {
        return locationSerializablePath;
    }

    public String getTicketSerializablePath() {
        return ticketSerializablePath;
    }

    public void populateDummyData() {
        //adauga locatii
        ArrayList<Location> locations = new ArrayList<>();
        Location location1 = new Location("TNB", "Bucharest", "Romania"),
                location2 = new Location("Romexpo", "Bucharest", "Romania");

        locations.add(location1);
        locations.add(location2);

        writeObjectToFile(locations, locationSerializablePath);

        //adauga events
        ArrayList<Event> events = new ArrayList<>();
        Event e1 = new TheaterEvent(location1, "Dineu Cu Prosti", LocalDateTime.now()),
                e2 = new ConcertEvent(location2, "AAA", LocalDateTime.now(), "Rock");

        events.add(e1);
        events.add(e2);

        writeObjectToFile(events, eventSerializablePath);

        //adauga clienti
        ArrayList<Client> clients = new ArrayList<>();
        Client client1 = new Client("Alin Dima", "Bucharest");
        Client client2 = new Client("Staniea Alex", "Bucharest");
        Client client3 = new Client("Ivascu", "Oltenita");

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);

        writeObjectToFile(clients, clientSerializablePath);

        //emite bilete
        ArrayList<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket(e1, client1);
        tickets.add(ticket);

        writeObjectToFile(tickets, ticketSerializablePath);

    }
}
