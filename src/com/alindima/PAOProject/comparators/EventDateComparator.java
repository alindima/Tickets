package com.alindima.PAOProject.comparators;

import com.alindima.PAOProject.models.events.Event;

import java.util.Comparator;

public class EventDateComparator implements Comparator<Event> {
    @Override
    public int compare(Event e1, Event e2) {
        return e1.getDateTime().compareTo(e2.getDateTime());
    }
}
