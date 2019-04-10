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
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == id) {
                return clients.get(i);
            }
        }

        return null;
    }

    public Client getClient(String name) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getName() == name) {
                return clients.get(i);
            }
        }

        return null;
    }
}
