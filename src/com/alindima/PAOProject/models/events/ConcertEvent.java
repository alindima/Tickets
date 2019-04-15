package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.time.LocalDateTime;

public class ConcertEvent extends Event {

    private String genre;

    public ConcertEvent(Location location, String name, LocalDateTime dateTime, String genre) {
        super(location, name, dateTime);

        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
