package com.alindima.PAOProject.models;

public class Client implements Comparable<Client> {
    private Integer id;
    private String name;
    private String city;

    private static Integer nrClients = 0;

    public Client(String name, String city) {
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int compareTo(Client c) {
        return name.compareTo(c.name);
    }
}
