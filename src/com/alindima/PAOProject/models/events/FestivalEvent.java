package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.time.LocalDateTime;

public class FestivalEvent extends Event {

    private Integer nrOfDays = 1;

    public FestivalEvent(Integer id, Location location, String name, LocalDateTime dateTime) {
        super(id, location, name, dateTime);

    }

    public Integer getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(Integer nrOfDays) {
        this.nrOfDays = nrOfDays;
    }
}
