package org.TobiaszRumian.jp.laboratorium3;
/*
 *  Program SymulatorFunkcji
 *  Pozwala symulować funkcjię y=sin(x*m)*s)
 *
 *  @author Tobiasz Rumian
 *  @version 1.0
 *   Data: 05 Listopad 2016 r.
 *   Indeks: 226131
 *   Grupa: śr 13:15 TN
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Graph extends JFrame {

    final static int SCREEN_X = 800;
    final static int SCREEN_Y = 800;

    private ArrayList<JSlider> sliders = new ArrayList<>();

    private final MainPanel mainPanel;
    private JMenuBar menuBar;

    private Graph() {
        super("Symulator funkcji y=sin(x*m)*s)");
        setSize(SCREEN_X, SCREEN_Y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainPanel = new MainPanel();
        menuBar = new JMenuBar();
        mainPanel.setFocusable(true);
        mainPanel.setLayout(new BorderLayout());
        createSlider(JSlider.VERTICAL, -100, 100, 0, 50, 10, "Przesuń X");
        createSlider(JSlider.VERTICAL, 0, 100, 50, 50, 10, "Skaluj X");
        createSlider(JSlider.VERTICAL, -100, 100, 0, 50, 10, "Przesuń Y");
        createSlider(JSlider.VERTICAL, 0, 200, 43, 10, 50, "Mnożnik X");
        setJMenuBar(menuBar);
        setContentPane(mainPanel);
        mainPanel.addLine(new Point(0, Graph.SCREEN_Y / 2), new Point(Graph.SCREEN_X, Graph.SCREEN_Y / 2));
        mainPanel.addLine(new Point(Graph.SCREEN_X / 2, 0), new Point(Graph.SCREEN_X / 2, Graph.SCREEN_Y));
        mainPanel.createGraph();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Graph();
    }

    private void createSlider(int arrangement, int start, int end, int now, int major, int minor, String name) {
        JSlider slider = new JSlider(arrangement, start, end, now);

        slider.addChangeListener(mainPanel);
        slider.setMajorTickSpacing(major);
        slider.setMinorTickSpacing(minor);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setName(name);
        JMenu menu = new JMenu(name);
        menu.add(slider);
        menuBar.add(menu);
        sliders.add(slider);
    }
}

