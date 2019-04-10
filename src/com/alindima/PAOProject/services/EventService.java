package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.events.Event;

import java.util.ArrayList;

public class EventService {
    private ArrayList<Event> events = new ArrayList<>();

    private static EventService instance = new EventService();

    public static EventService getInstance() {
        return instance;
    }

    private EventService() {
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getEvent(String name) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName() == name) {
                return events.get(i);
            }
        }

        return null;
    }
}