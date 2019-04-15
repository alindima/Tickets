package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TheaterEvent extends Event {
    private List<String> distribution = new LinkedList<>();

    public TheaterEvent(Location location, String name, LocalDateTime dateTime) {
        super(location, name, dateTime);
    }

    public List<String> getDistribution() {
        return distribution;
    }

    public void addToDistribution(String actor) {
        distribution.add(actor);
    }
}
