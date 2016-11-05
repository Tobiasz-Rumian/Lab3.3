package org.TobiaszRumian.jp.laboratorium3;
/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 05 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Vector;


class MainPanel extends JPanel implements ChangeListener {

    private static final long serialVersionUID = 1L;
    private Vector<Point> points = new Vector<>();
    private Vector<Line> lines = new Vector<>();
    private int scaleX = 50, shiftY = 0, shiftX = 0, multiplier = 25;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < points.size() - 1; i++) {
            points.get(i).draw(g);
            g.drawLine(points.get(i).getX(), points.get(i).getY(), points.get(i + 1).getX(), points.get(i + 1).getY());
        }

        for (Line l : lines)
            l.draw(g);
    }

    private void addPoint(Point point) {
        points.add(point);
    }

    void addLine(Point x1, Point x2) {
        lines.add(new Line(x1, x2));
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if (source.getName().equals("Przesuń X")) {
            this.shiftX = source.getValue();
            createGraph();
        } else if (source.getName().equals("Skaluj X")) {
            this.scaleX = source.getValue();
            createGraph();
        } else if (source.getName().equals("Przesuń Y")) {
            this.shiftY = source.getValue() / 10;
            createGraph();
        } else if (source.getName().equals("Mnożnik X")) {
            this.multiplier = source.getValue();
            createGraph();
        }
    }

    void createGraph() {
        points.clear();
        float y, sX = shiftX * 10, sY = shiftY * 100;
        for (int i = -800; i < 800; i++) {
            y = (float) (Math.sin(i * multiplier) * scaleX);
            y -= Graph.SCREEN_Y / 2;
            addPoint(new Point(i + Graph.SCREEN_X / 2 + sX, -y + sY));
        }
        lines.set(0, new Line(new Point(sX, Graph.SCREEN_Y / 2 + sY), new Point(Graph.SCREEN_X + sX, Graph.SCREEN_Y / 2 + sY)));
        lines.set(1, new Line(new Point(Graph.SCREEN_X / 2 + sX, sY), new Point(Graph.SCREEN_X / 2 + sX, Graph.SCREEN_Y + sY)));
        repaint();
    }

}

