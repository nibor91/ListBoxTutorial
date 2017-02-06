package com.sabel.listBoxTut;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Robin on 06.02.2017.
 */
public class GrundFenster extends JFrame {
    private Container c;
    private JPanel jPanelNorth;
    private JPanel jPanelCenter;
    private JPanel jPanelSouth;
    private JPanel jPanelWest;
    private JPanel jPanelEast;
    private JPanel jpSelect;
    private JPanel jpOrder;
    private JRadioButton[] jRadioButtons;
    private ButtonGroup buttonGroup;
    private ButtonGroup buttonGroup2;
    private JLabel header;
    //private JList jList;
    private JScrollPane jScrollPane;
    private AutoDatenbank autoDatenbank;
  //  private DefaultListModel<Auto> autoListModel;
    private JButton jbtnDelet;
    private MeinActionListener meinActionListener;


    public GrundFenster() throws HeadlessException {
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
        jpSelect = new JPanel();
        jpOrder = new JPanel();
        jRadioButtons = new JRadioButton[6];
        jRadioButtons[2] = new JRadioButton("Vertical");
        jRadioButtons[1] = new JRadioButton("Horizontal-Split");
        jRadioButtons[0] = new JRadioButton("Vertical-Split");
        jRadioButtons[3] = new JRadioButton("Single-Select");
        jRadioButtons[4] = new JRadioButton("Intervall");
        jRadioButtons[5] = new JRadioButton("Multi-Intervall");
        meinActionListener = new MeinActionListener();
        buttonGroup = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        jbtnDelet = new JButton("Delete");
        jPanelCenter = new JPanel();
        jPanelNorth = new JPanel();
        jPanelWest = new JPanel();
        jPanelEast = new JPanel();
        jPanelEast.setLayout(new BoxLayout(jPanelEast, BoxLayout.Y_AXIS));
        jpOrder.setLayout(new BoxLayout(jpOrder, BoxLayout.Y_AXIS));
        jpSelect.setLayout(new BoxLayout(jpSelect, BoxLayout.Y_AXIS));

        jPanelSouth = new JPanel();
        header = new JLabel(" ");
//        autoListModel = new DefaultListModel<>();
        c = getContentPane();
        autoDatenbank = new AutoDatenbank();
      //  jList = new JList(autoListModel);
        jScrollPane = new JScrollPane(
//                jList
        );
    }

    private void modelBefuellen() {
        autoDatenbank.generateTestdaten(33);
        for (Auto a : autoDatenbank.getAutoListe()) {
//            autoListModel.addElement(a);
        }
    }

    private void adActionlistener() {
        jbtnDelet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (jList.getSelectedIndex() > -1)
//                    while (jList.getSelectedIndex()> -1)
//                        autoDatenbank.removeAuto(autoListModel.remove(jList.getSelectedIndex()));
            }
        });
//        jList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//
//                if (jList.getSelectedIndex() > -1) {
//                    System.out.println(jList.getSelectedIndex());
//                    header.setText("Kennzeichen: " + autoListModel.get(jList.getSelectedIndex()).getKennzeichen() + "Fahrgestellnummer: " + autoListModel.get(jList.getSelectedIndex()).getFahrgestellnummer());
//                    pack();
//                }
//            }
//        });
        for (JRadioButton j : jRadioButtons) {
            j.addItemListener(meinActionListener);
        }
    }

    private void zusammensetzen() {
        buttonGroup.add(jRadioButtons[0]);
        buttonGroup.add(jRadioButtons[1]);
        buttonGroup.add(jRadioButtons[2]);
        jpOrder.add(jRadioButtons[0]);
        jpOrder.add(jRadioButtons[1]);
        jpOrder.add(jRadioButtons[2]);
        buttonGroup2.add(jRadioButtons[3]);
        buttonGroup2.add(jRadioButtons[4]);
        buttonGroup2.add(jRadioButtons[5]);
        jpSelect.add(jRadioButtons[3]);
        jpSelect.add(jRadioButtons[4]);
        jpSelect.add(jRadioButtons[5]);
        jPanelEast.add(jpOrder);
        jpSelect.setBorder(new LineBorder(Color.black));
        jpOrder.setBorder(new LineBorder(Color.black));

        jPanelEast.add(jpSelect);
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
//                jList.setLayoutOrientation(JList.VERTICAL_WRAP);
            } else if (jRadioButtons[1].isSelected()) {
//                jList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            } else if (jRadioButtons[2].isSelected()) {
//                jList.setLayoutOrientation(JList.VERTICAL);
            }
            if (jRadioButtons[3].isSelected()) {
//                jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            } else if (jRadioButtons[4].isSelected()) {
//                jList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            } else if (jRadioButtons[5].isSelected()) {
//                jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            }


        }
    }
}
