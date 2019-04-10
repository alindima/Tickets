package com.alindima.PAOProject.models;

public class Client {
    private Integer id;
    private String name;

    private static Integer nrClients = 0;

    public Client(String name) {
        this.name = name;
        this.id = ++nrClients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
