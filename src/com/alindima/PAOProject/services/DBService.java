package com.alindima.PAOProject.services;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.models.Ticket;
import com.alindima.PAOProject.models.events.*;

import java.sql.*;
import java.util.ArrayList;

public class DBService {

    private static DBService instance = new DBService();

    private Connection connection = null;

    private DBService() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pao?serverTimezone=UTC",
                    "root", "root");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBService getInstance() {
        return instance;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Client> getAllClients() {
        ArrayList<Client> clients = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from clients");

            while (resultSet.next()) {
                Client c = new Client(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3));

                clients.add(c);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public ArrayList<Location> getAllLocations() {
        ArrayList<Location> locations = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from locations");

            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4));

                locations.add(l);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return locations;
    }

    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> events = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from events");

            while (resultSet.next()) {
                int type = resultSet.getInt("type");
                Integer locationId = resultSet.getInt("location_id");

                Event e = null;
                Location l = LocationService.getInstance().getLocation(locationId);

                boolean add = true;

                switch (type) {
                    case 1:
                        e = new TheaterEvent(resultSet.getInt("id"), l, resultSet.getString("name"),
                                resultSet.getTimestamp("datetime").toLocalDateTime());
                        break;
                    case 2:
                        e = new FestivalEvent(resultSet.getInt("id"), l, resultSet.getString("name"),
                                resultSet.getTimestamp("datetime").toLocalDateTime());
                        break;
                    case 3:
                        e = new ConcertEvent(resultSet.getInt("id"), l, resultSet.getString("name"),
                                resultSet.getTimestamp("datetime").toLocalDateTime());
                        break;
                    case 4:
                        e = new OperaEvent(resultSet.getInt("id"), l, resultSet.getString("name"),
                                resultSet.getTimestamp("datetime").toLocalDateTime());
                        break;
                    default:
                        add = false;
                        break;
                }

                if (add) {
                    events.add(e);
                }

            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return events;
    }

    public ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> tickets = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from tickets");

            while (resultSet.next()) {
                Client c = ClientService.getInstance().getClient(resultSet.getInt("client_id"));
                Event e = EventService.getInstance().getEvent(resultSet.getInt("event_id"));
                Ticket t = new Ticket(resultSet.getInt("id"), e, c);

                tickets.add(t);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }
}
