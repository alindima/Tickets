package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Location;

import java.util.ArrayList;

public class LocationService {

    private LogService logService = LogService.getInstance();

    private ArrayList<Location> locations = new ArrayList<>();

    private static LocationService instance = new LocationService();

    public static LocationService getInstance() {
        return instance;
    }

    private static FileSerializableService fileSerializableService = FileSerializableService.getInstance();

    private LocationService() {
    }

    public void addLocation(Location location) {
        logService.writeLine("Add location");

        locations.add(location);
    }

    public Location getLocation(Integer index) throws IndexOutOfBoundsException {
        logService.writeLine("Get location by index");

        return locations.get(index);
    }

    public Location getLocation(String venueName) {
        logService.writeLine("Get location by venue name");

        for (Location l : locations) {
            if (l.getVenue().equals(venueName)) {
                return l;
            }
        }

        return null;
    }

    public ArrayList<Location> getAllLocations() {
        logService.writeLine("Get all locations");

        return locations;
    }

    public void readDataFromFile(){
        locations = (ArrayList<Location>) fileSerializableService.readObjectFromFile(fileSerializableService.getLocationSerializablePath());
    }

    public void writeDataToFile(){
        fileSerializableService.writeObjectToFile(locations, fileSerializableService.getLocationSerializablePath());
    }
}
