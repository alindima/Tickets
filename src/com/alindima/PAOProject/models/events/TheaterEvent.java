package com.alindima.PAOProject.models.events;

import com.alindima.PAOProject.models.Location;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class TheaterEvent extends Event {
    private Set<String> distribution = new TreeSet<>();

    public TheaterEvent(Integer id, Location location, String name, LocalDateTime dateTime) {
        super(id, location, name, dateTime);
    }

    public Set<String> getDistribution() {
        return distribution;
    }

    public void addToDistribution(String actor) {
        distribution.add(actor);
    }
}
