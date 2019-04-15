package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.models.events.*;
import com.alindima.PAOProject.comparators.EventNameComparator;
import com.alindima.PAOProject.comparators.EventDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        for (Event e : events) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        return null;
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public List<Event> getEventsByLocation(Location l) {
        List<Event> auxList = new ArrayList<>();

        for (Event e : events) {
            if(e.getLocation().equals(l)){
                auxList.add(e);
            }
        }

        return auxList;
    }

    public List<Event> getEventsByDate(LocalDate date) {
        List<Event> auxList = new ArrayList<>();

        for (Event e : events) {
            if (e.getDateTime().toLocalDate().equals(date)) {
                auxList.add(e);
            }
        }

        return auxList;
    }

    public List<Event> getSortedEventsByName() {
        ArrayList<Event> events = (ArrayList<Event>) this.events.clone();
        events.sort(new EventNameComparator());

        return events;
    }

    public List<Event> getSortedEventsByDate() {
        ArrayList<Event> events = (ArrayList<Event>) this.events.clone();
        events.sort(new EventDateComparator());

        return events;
    }

    public List<ConcertEvent> getConcertEvents() {
        ArrayList<ConcertEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof ConcertEvent) {
                auxList.add((ConcertEvent) event);
            }
        }

        return auxList;
    }

    public List<FestivalEvent> getFestivalEvents() {
        ArrayList<FestivalEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof FestivalEvent) {
                auxList.add((FestivalEvent) event);
            }
        }

        return auxList;
    }

    public List<OperaEvent> getOperaEvents() {
        ArrayList<OperaEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof OperaEvent) {
                auxList.add((OperaEvent) event);
            }
        }

        return auxList;
    }


    public List<TheaterEvent> getTheaterEvents() {
        ArrayList<TheaterEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof TheaterEvent) {
                auxList.add((TheaterEvent) event);
            }
        }

        return auxList;
    }

}
