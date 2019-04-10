package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.time.LocalDateTime;

public class ConcertEvent extends Event {

    public ConcertEvent(Location location, String name, LocalDateTime dateTime) {
        super(location, name, dateTime);
    }

}
