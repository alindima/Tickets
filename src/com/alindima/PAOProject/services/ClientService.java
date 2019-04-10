package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;

import java.util.ArrayList;

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
}
