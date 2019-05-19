package com.alindima.PAOProject.models;

import java.io.Serializable;

public class Client implements Comparable<Client>, Serializable {
    private Integer id;
    private String name;
    private String city;

    private static Integer maxId = 0;

    public Client(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;

        maxId = Integer.max(id, maxId);
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

    public Integer getMaxId() {
        return maxId;
    }

    @Override
    public int compareTo(Client c) {
        return name.compareTo(c.name);
    }

    public boolean equals(Client client) {
        return id.equals(client.id);
    }
}
