package com.alindima.PAOProject.comparators;

import com.alindima.PAOProject.models.events.Event;

import java.util.Comparator;

public class EventNameComparator implements Comparator<Event> {
    public int compare(Event e1, Event e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
