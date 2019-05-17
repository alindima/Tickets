package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;

public abstract class Event implements Serializable {
    protected Location location;

    protected String name;

    protected String description = "";

    protected LocalDateTime dateTime;

    public Event(Location location, String name, LocalDateTime dateTime) {
        this.location = location;
        this.name = name;
        this.dateTime = dateTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
