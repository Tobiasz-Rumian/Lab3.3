package org.TobiaszRumian.jp.laboratorium3;

/**
 * Created by Tobiasz Rumian on 03.11.2016.
 */

import javax.swing.*;
import java.awt.*;
import java.util.Vector;
/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 01 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */


class MainPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    Vector<Point> Points = new Vector<>();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point f : Points)
            f.draw(g);
    }

    void addPoint(Point point) {
        Points.add(point);
        repaint();
    }
}

