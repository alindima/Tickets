package com.alindima.PAOProject.models;

public class Location {
    private String venue;

    private String city;

    private String country;

    public Location(String venue, String city, String country) {
        this.venue = venue;
        this.city = city;
        this.country = country;
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
