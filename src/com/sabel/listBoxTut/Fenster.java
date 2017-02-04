package com.sabel.listBoxTut;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Robin on 04.02.2017.
 */
public class Fenster extends JFrame {

    private Container c;
    private JPanel jPanelNorth;
    private JPanel jPanelCenter;
    private JPanel jPanelSouth;
    private JPanel jPanelWest;
    private JPanel jPanelEast;
    private JLabel header;
    private JList jList;
    private JScrollPane jScrollPane;
    private AutoDatenbank autoDatenbank;
    private DefaultListModel<Auto> autoListModel;
    private JButton jbtnDelet;


    public Fenster() throws HeadlessException {
        initComponents();
        zusammensetzen();
        modelBefuellen();
        pack();
        setVisible(true);
    }

    private void zusammensetzen() {
        c.add(jPanelCenter);
        jPanelCenter.add(jScrollPane);
        c.add(jPanelNorth, BorderLayout.NORTH);
        jPanelSouth.add(jbtnDelet);
        jPanelNorth.add(header);
        c.add(jPanelSouth, BorderLayout.SOUTH);
    }

    private void initComponents() {
        jbtnDelet = new JButton("Delete");
        jPanelCenter = new JPanel();
        jPanelNorth = new JPanel();
        jPanelWest = new JPanel();
        jPanelEast = new JPanel();
        jPanelSouth = new JPanel();
        header = new JLabel(" ");
        autoListModel = new DefaultListModel<>();
        c = getContentPane();
        autoDatenbank = new AutoDatenbank();
        jList = new JList(autoListModel);
        jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(250, 250));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autoverwaltung");
        adActionlistener();

    }

    private void adActionlistener() {

        jbtnDelet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jList.getSelectedIndex() > -1)
                    autoDatenbank.removeAuto(autoListModel.remove(jList.getSelectedIndex()));
            }
        });
        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jList.getSelectedIndex() > -1) {
                    System.out.println(jList.getSelectedIndex());
                    header.setText("Kennzeichen: " + autoListModel.get(jList.getSelectedIndex()).getKennzeichen() + "Fahrgestellnummer: " + autoListModel.get(jList.getSelectedIndex()).getFahrgestellnummer());
                   pack();
                }
            }
        });

    }

    private void modelBefuellen() {
        autoDatenbank.generateTestdaten(33);
        for (Auto a : autoDatenbank.getAutoListe()) {
            autoListModel.addElement(a);
        }
    }
}
