package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.models.events.*;
import com.alindima.PAOProject.comparators.EventNameComparator;
import com.alindima.PAOProject.comparators.EventDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;

public class EventService {

    private LogService logService = LogService.getInstance();

    private ArrayList<Event> events = new ArrayList<>();

    private static EventService instance = new EventService();

    public static EventService getInstance() {
        return instance;
    }

    private static FileSerializableService fileSerializableService = FileSerializableService.getInstance();

    private EventService() {
    }

    public void addEvent(Event event) {
        logService.writeLine("Add event");

        events.add(event);
    }

    public Event getEvent(String name) {
        logService.writeLine("Get event by name");

        for (Event e : events) {
            if (e.getName().equals(name)) {
                return e;
            }
        }

        return null;
    }

    public Event getEvent(Integer id) {
        logService.writeLine("Get event by id");

        for (Event e : events) {
            if (e.getId().equals(id)) {
                return e;
            }
        }

        return null;
    }

    public ArrayList<Event> getAllEvents() {
        logService.writeLine("Get all events");

        return events;
    }

    public ArrayList<Event> getEventsByLocation(Location l) {
        logService.writeLine("Get events by location");

        ArrayList<Event> auxList = new ArrayList<>();

        for (Event e : events) {
            if(e.getLocation().equals(l)){
                auxList.add(e);
            }
        }

        return auxList;
    }

    public ArrayList<Event> getEventsByDate(LocalDate date) {
        logService.writeLine("get events by date");

        ArrayList<Event> auxList = new ArrayList<>();

        for (Event e : events) {
            if (e.getDateTime().toLocalDate().equals(date)) {
                auxList.add(e);
            }
        }

        return auxList;
    }

    public ArrayList<Event> getSortedEventsByName() {
        logService.writeLine("Get sorted events by name");

        ArrayList<Event> events = (ArrayList<Event>) this.events.clone();
        events.sort(new EventNameComparator());

        return events;
    }

    public ArrayList<Event> getSortedEventsByDate() {
        logService.writeLine("Get sorted events by date");

        ArrayList<Event> events = (ArrayList<Event>) this.events.clone();
        events.sort(new EventDateComparator());

        return events;
    }

    public ArrayList<ConcertEvent> getConcertEvents() {
        logService.writeLine("Get concert events");

        ArrayList<ConcertEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof ConcertEvent) {
                auxList.add((ConcertEvent) event);
            }
        }

        return auxList;
    }

    public ArrayList<FestivalEvent> getFestivalEvents() {
        logService.writeLine("Get festival events");

        ArrayList<FestivalEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof FestivalEvent) {
                auxList.add((FestivalEvent) event);
            }
        }

        return auxList;
    }

    public ArrayList<OperaEvent> getOperaEvents() {
        logService.writeLine("Get opera events");

        ArrayList<OperaEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof OperaEvent) {
                auxList.add((OperaEvent) event);
            }
        }

        return auxList;
    }

    public ArrayList<TheaterEvent> getTheaterEvents() {
        logService.writeLine("Get theater events");

        ArrayList<TheaterEvent> auxList = new ArrayList<>();

        for(Event event : events){
            if (event instanceof TheaterEvent) {
                auxList.add((TheaterEvent) event);
            }
        }

        return auxList;
    }

    public void readDataFromDB() {
        DBService dbService = DBService.getInstance();
        events = dbService.getAllEvents();
    }

    public void readDataFromFile(){
        events = (ArrayList<Event>) fileSerializableService.readObjectFromFile(fileSerializableService.getEventSerializablePath());
    }

    public void writeDataToFile(){
        fileSerializableService.writeObjectToFile(events, fileSerializableService.getEventSerializablePath());
    }

}
