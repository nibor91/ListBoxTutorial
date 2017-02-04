package com.sabel.listBoxTut;

import javax.swing.*;
import java.awt.*;

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
    private JList jList;
    private JScrollPane jScrollPane;
    private  AutoDatenbank autoDatenbank;

    public Fenster() throws HeadlessException {
        initComponents();
    }

    private void initComponents() {
        jPanelCenter = new JPanel();
        jPanelNorth = new JPanel();
        jPanelWest = new JPanel();
        jPanelEast = new JPanel();
        jPanelSouth = new JPanel();
        autoDatenbank = new AutoDatenbank();
        autoDatenbank.generateTestdaten(33);
    }
}
