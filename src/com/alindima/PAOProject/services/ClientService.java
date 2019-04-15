package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientService {
    private ArrayList<Client> clients = new ArrayList<>();

    private static ClientService instance = new ClientService();

    public static ClientService getInstance() {
        return instance;
    }

    private ClientService() {
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public Client getClient(Integer id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public Client getClient(String name) {
        for (Client c : clients) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public List<Client> getClientsByCity(String city) {
        List<Client> auxList = new ArrayList<>();

        for (Client c : clients) {
            if (c.getCity().equals(city)) {
                auxList.add(c);
            }
        }

        return auxList;
    }

    public List<Client> getSortedClientsByName() {
        ArrayList<Client> clients = (ArrayList<Client>) this.clients.clone();
        Collections.sort(clients);

        return clients;
    }
}
