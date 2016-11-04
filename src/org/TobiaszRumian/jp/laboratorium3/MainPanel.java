package org.TobiaszRumian.jp.laboratorium3;

/**
 * Created by Tobiasz Rumian on 03.11.2016.
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 01 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */


class MainPanel extends JPanel implements ChangeListener {

    private static final long serialVersionUID = 1L;
    ArrayList<Point> points = new ArrayList<>();
    Vector<Line> lines = new Vector<>();
    private int precision=10,scale=10,shift=0,probe=1000;
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point p : points)
            p.draw(g);
        for (Line l:lines)
            l.draw(g);
    }

    void addPoint(Point point) {
        points.add(point);
        repaint();
    }

    void addLine(Point x1, Point x2){
        lines.add(new Line(x1,x2));
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if(source.getName().equals("Przesuń")){
            this.shift=source.getValue();
            createGraph();
        }
        else if(source.getName().equals("SkalujX")) {
            this.precision=source.getValue();
            createGraph();
        }
        else if(source.getName().equals("SkalujY")) {
            this.scale=source.getValue();
            createGraph();
        }
        else if(source.getName().equals("Próbkowanie")) {
            this.probe=source.getValue();
            createGraph();
        }
    }
    public void createGraph()
    {
        float y;
        float x;
        points.clear();
        float z = (float)Graph.SCREEN_X/(float)probe;
        float z1=z;
        System.err.println("z1: "+z);
        int s=-Graph.SCREEN_X/2;
        for(int i=-probe/2;i<probe/2;i++) {
            z+=z;
            z1+=z;
            if(z>=1&&s<Graph.SCREEN_X/2)
            {
            x=i;
            y= (float) Math.sin((x/precision)+shift)*scale;
            y-=Graph.SCREEN_Y/2;
            y=(-y);

                addPoint(new Point(z1+Graph.SCREEN_X/2,y));

                z=(float)Graph.SCREEN_X/(float)probe;
            }

            /*System.err.println("z: "+z);
            System.err.println("s: "+s);
            System.err.println("y: "+y);
            System.err.println("x: "+(s+Graph.SCREEN_X/2));
*/
        }
    }
}

