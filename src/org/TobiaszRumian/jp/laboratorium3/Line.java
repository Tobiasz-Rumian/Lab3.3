package org.TobiaszRumian.jp.laboratorium3;
/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 05 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */

import java.awt.*;

class Line {

    private Point x1, x2;

    Line(Point x1, Point x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    void draw(Graphics g) {
        g.drawLine(x1.getX(), x1.getY(), x2.getX(), x2.getY());
    }
}
