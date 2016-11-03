package org.TobiaszRumian.jp.laboratorium3;

/**
 * Created by Tobiasz Rumian on 03.11.2016.
 */

import java.awt.*;

/*
 * @version 1.0
 * @author Tobiasz Rumian
 * Data: 01 Listopad 2016 r.
 * Indeks: 226131
 * Grupa: śr 13:15 TN
 */


class Point {

    float x, y;

    Point(float x, float y) {
        this.x = x; this.y = y;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

    void draw(Graphics g) {
        g.fillOval((int) (x - 3), (int) (y - 3), 6, 6);
    }
}

