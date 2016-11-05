package org.TobiaszRumian.jp.laboratorium3;

/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 05 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */

import java.awt.*;

class Point {

    private float x, y;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return (int) x;
    }

    int getY() {
        return (int) y;
    }

    void draw(Graphics g) {
        g.fillOval((int) (x - 3), (int) (y - 3), 6, 6);
    }
}

