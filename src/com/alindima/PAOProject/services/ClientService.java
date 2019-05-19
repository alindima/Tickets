package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;

import java.util.ArrayList;
import java.util.Collections;

public class ClientService {

    private LogService logService = LogService.getInstance();

    private ArrayList<Client> clients = new ArrayList<>();

    private static ClientService instance = new ClientService();

    private static FileSerializableService fileSerializableService = FileSerializableService.getInstance();

    public static ClientService getInstance() {
        return instance;
    }

    private ClientService() {
    }

    public void addClient(Client client) {
        logService.writeLine("Add client");

        clients.add(client);
    }

    public Client getClient(Integer id) {
        logService.writeLine("Get client by id");

        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public Client getClient(String name) {
        logService.writeLine("Get client by name");

        for (Client c : clients) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    public ArrayList<Client> getAllClients() {
        logService.writeLine("Get all clients");

        return clients;
    }

    public ArrayList<Client> getClientsByCity(String city) {
        logService.writeLine("Get clients by city");

        ArrayList<Client> auxList = new ArrayList<>();

        for (Client c : clients) {
            if (c.getCity().equals(city)) {
                auxList.add(c);
            }
        }

        return auxList;
    }

    public ArrayList<Client> getSortedClientsByName() {
        logService.writeLine("Get sorted clients by name");

        ArrayList<Client> clients = (ArrayList<Client>) this.clients.clone();
        Collections.sort(clients);

        return clients;
    }

    public String format(ArrayList<Client> clients) {
        StringBuilder text = new StringBuilder();

        for (Client c : clients) {
            text.append(c.getId()).append(". ").append(c.getName()).append(", ").append("City: ").append(c.getCity())
                    .append("\n");
        }

        return text.toString();
    }

    public void readDataFromDB() {
        DBService dbService = DBService.getInstance();
        clients = dbService.getAllClients();
    }

    public void readDataFromFile(){
        clients = (ArrayList<Client>) fileSerializableService.readObjectFromFile(fileSerializableService.getClientSerializablePath());
    }

    public void writeDataToFile(){
        fileSerializableService.writeObjectToFile(clients, fileSerializableService.getClientSerializablePath());
    }
}
