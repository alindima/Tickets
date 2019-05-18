package com.alindima.PAOProject;

import com.alindima.PAOProject.models.Client;
import com.alindima.PAOProject.services.ClientService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManageClientsPage {
    private JPanel panel;
    private JButton backButton;
    private JSplitPane splitPanel;
    private JScrollPane leftPanel;
    private JPanel topPanel;
    private JPanel rightPanel;
    private JButton showAllButton;
    private JTextPane textPanel;
    private JLabel titleLabel;
    private JButton sortByNameButton;
    private JButton getByCity;

    private ClientService clientService = ClientService.getInstance();

    public ManageClientsPage() {

        splitPanel.setDividerLocation(700);

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllClients();
            }
        });
        sortByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSortedByName();
            }
        });
        getByCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getByCity();
            }
        });
    }

    private void showAllClients() {
        ArrayList<Client> clients = clientService.getAllClients();

        textPanel.setText(clientService.format(clients));
    }

    private void showSortedByName() {
        ArrayList<Client> clients = clientService.getSortedClientsByName();

        textPanel.setText(clientService.format(clients));
    }

    private void getByCity() {
        String city = JOptionPane.showInputDialog("Type a city");

        ArrayList<Client> clients = clientService.getClientsByCity(city);

        if (clients.size() == 0){
            textPanel.setText("No clients found");

            return;
        }

        textPanel.setText(clientService.format(clients));
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
