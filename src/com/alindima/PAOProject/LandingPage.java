package com.alindima.PAOProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage {
    private JFrame frame;

    private JButton manageClientsButton;
    private JPanel landingPanel;
    private JButton manageLocationsButton;

    private ManageClientsPage manageClientsPage;
    private ManageLocationsPage manageLocationsPage;

    private LandingPage() {

        manageClientsPage = new ManageClientsPage();
        manageLocationsPage = new ManageLocationsPage();

        manageClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageClients();
            }
        });

        manageLocationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageLocations();
            }
        });
    }

    private void createGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLandingPage();
    }

    public void run() {
        frame.pack();
        frame.setVisible(true);
    }

    private void setLandingPage() {
        frame.setTitle("Home");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setContentPane(landingPanel);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private void setManageClientsPage() {
        frame.setTitle("Manage clients");

        frame.setContentPane(manageClientsPage.getPanel());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.pack();
        frame.setVisible(true);
    }

    private void setManageLocationsPage() {
        frame.setTitle("Manage event locations");
        frame.setPreferredSize(new Dimension(1500, 1000));
        frame.setContentPane(manageLocationsPage.getPanel());

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        frame.pack();
        frame.setVisible(true);
    }

    public static LandingPage getLandingPage() {
        LandingPage landingPage = new LandingPage();
        landingPage.createGUI();

        return landingPage;
    }

    private void manageClients() {
        manageClientsPage.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLandingPage();
            }
        });

        setManageClientsPage();
    }

    private void manageLocations() {
        manageLocationsPage.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setLandingPage();
            }
        });

        setManageLocationsPage();
    }
}
