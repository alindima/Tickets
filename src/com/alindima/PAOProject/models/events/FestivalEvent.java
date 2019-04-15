package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.time.LocalDateTime;

public class FestivalEvent extends Event {

    private Integer nrOfDays;

    public FestivalEvent(Location location, String name, LocalDateTime dateTime, Integer nrOfDays) {
        super(location, name, dateTime);

        this.nrOfDays = nrOfDays;
    }

    public Integer getNrOfDays() {
        return nrOfDays;
    }

    public void setNrOfDays(Integer nrOfDays) {
        this.nrOfDays = nrOfDays;
    }
}
