package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Location;

import java.util.ArrayList;

public class LocationService {
    private ArrayList<Location> locations = new ArrayList<>();

    private static LocationService instance = new LocationService();

    public static LocationService getInstance() {
        return instance;
    }

    private LocationService() {
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public Location getLocation(Integer index) throws IndexOutOfBoundsException {
        return locations.get(index);
    }

    public Location getLocation(String venueName) {
        for (Location l : locations) {
            if (l.getVenue().equals(venueName)) {
                return l;
            }
        }

        return null;
    }
}
