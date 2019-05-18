package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;
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

    public ArrayList<Location> getLocationsByCity(String city) {
        logService.writeLine("Get locations by city");

        ArrayList<Location> auxList = new ArrayList<>();

        for (Location l : locations) {
            if (l.getCity().equals(city)) {
                auxList.add(l);
            }
        }

        return auxList;
    }

    public ArrayList<Location> getAllLocations() {
        logService.writeLine("Get all locations");

        return locations;
    }

    public String format(ArrayList<Location> locations) {
        StringBuilder text = new StringBuilder();

        for (Location c : locations) {
            text.append("Venue: ").append(c.getVenue()).append(", City: ").append(c.getCity()).append(", ")
                    .append("Country: ").append(c.getCountry()).append("\n");
        }

        return text.toString();
    }

    public void readDataFromFile(){
        locations = (ArrayList<Location>) fileSerializableService.readObjectFromFile(fileSerializableService.getLocationSerializablePath());
    }

    public void writeDataToFile(){
        fileSerializableService.writeObjectToFile(locations, fileSerializableService.getLocationSerializablePath());
    }
}
