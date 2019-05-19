package com.alindima.PAOProject.models;

import java.io.Serializable;

public class Location implements Serializable {
    private Integer id;

    private String venue;

    private String city;

    private String country;

    public Location(Integer id, String venue, String city, String country) {
        this.id = id;
        this.venue = venue;
        this.city = city;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
