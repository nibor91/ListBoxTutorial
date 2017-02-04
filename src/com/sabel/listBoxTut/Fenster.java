package com.sabel.listBoxTut;


import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
    private JRadioButton[] jRadioButtons;
    private ButtonGroup buttonGroup;
    private JLabel header;
    private JList jList;
    private JScrollPane jScrollPane;
    private AutoDatenbank autoDatenbank;
    private DefaultListModel<Auto> autoListModel;
    private JButton jbtnDelet;
    private MeinActionListener meinActionListener;


    public Fenster() throws HeadlessException {
        initComponents();
        setTitle("Autoverwaltung");
        zusammensetzen();
        modelBefuellen();
        adActionlistener();
        jScrollPane.setPreferredSize(new Dimension(250, 250));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    private void initComponents() {
        jRadioButtons = new JRadioButton[3];
        jRadioButtons[2] = new JRadioButton("Vertical");
        jRadioButtons[1] = new JRadioButton("Horizontal-Split");
        jRadioButtons[0] = new JRadioButton("Vertical-Split");
        meinActionListener = new MeinActionListener();
        buttonGroup = new ButtonGroup();
        jbtnDelet = new JButton("Delete");
        jPanelCenter = new JPanel();
        jPanelNorth = new JPanel();
        jPanelWest = new JPanel();
        jPanelEast = new JPanel();
        jPanelEast.setLayout(new BoxLayout(jPanelEast, BoxLayout.Y_AXIS));
        jPanelSouth = new JPanel();
        header = new JLabel(" ");
        autoListModel = new DefaultListModel<>();
        c = getContentPane();
        autoDatenbank = new AutoDatenbank();
        jList = new JList(autoListModel);
        jScrollPane = new JScrollPane(jList);
    }
    private void modelBefuellen() {
        autoDatenbank.generateTestdaten(33);
        for (Auto a : autoDatenbank.getAutoListe()) {
            autoListModel.addElement(a);
        }
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
        for (JRadioButton j : jRadioButtons) {
            j.addItemListener(meinActionListener);
        }
    }
    private void zusammensetzen() {
        buttonGroup.add(jRadioButtons[0]);
        buttonGroup.add(jRadioButtons[1]);
        buttonGroup.add(jRadioButtons[2]);
        jPanelEast.add(jRadioButtons[0]);
        jPanelEast.add(jRadioButtons[1]);
        jPanelEast.add(jRadioButtons[2]);
        jPanelCenter.add(jScrollPane);
        jPanelSouth.add(jbtnDelet);
        jPanelNorth.add(header);
        c.add(jPanelEast, BorderLayout.EAST);
        c.add(jPanelCenter);
        c.add(jPanelNorth, BorderLayout.NORTH);
        c.add(jPanelSouth, BorderLayout.SOUTH);
    }
    private class MeinActionListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (jRadioButtons[0].isSelected()) {
                jList.setLayoutOrientation(JList.VERTICAL_WRAP);
            } else if (jRadioButtons[1].isSelected()) {
                jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            } else if (jRadioButtons[2].isSelected()) {
                jList.setLayoutOrientation(JList.VERTICAL);
            }

        }
    }
}
