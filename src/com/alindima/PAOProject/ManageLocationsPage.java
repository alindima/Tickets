package com.alindima.PAOProject;

import com.alindima.PAOProject.models.Location;
import com.alindima.PAOProject.services.LocationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManageLocationsPage {
    private JPanel panel;
    private JSplitPane splitPanel;
    private JScrollPane leftPanel;
    private JTextPane textPanel;
    private JPanel rightPanel;
    private JButton showAllButton;
    private JButton backButton;
    private JPanel topPanel;
    private JLabel titleLabel;
    private JButton getLocationByCityButton;

    private LocationService locationService = LocationService.getInstance();

    public ManageLocationsPage() {
        splitPanel.setDividerLocation(700);

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAll();
            }
        });
        getLocationByCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showByCity();
            }
        });
    }

    private void showAll() {
        ArrayList<Location> locations = locationService.getAllLocations();

        textPanel.setText(locationService.format(locations));
    }

    private void showByCity() {
        String city = JOptionPane.showInputDialog("Type a city");

        ArrayList<Location> locations = locationService.getLocationsByCity(city);

        if (locations.size() == 0){
            textPanel.setText("No locations found");

            return;
        }

        textPanel.setText(locationService.format(locations));
    }


    public JPanel getPanel() {
        return panel;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
