package org.TobiaszRumian.jp.laboratorium3;

import java.awt.*;

/**
 * Created by Tobiasz Rumian on 04.11.2016.
 */
public class Line {
    Point x1, x2;

    Line(Point x1, Point x2) {
        this.x1 = x1; this.x2 = x2;
    }

    void draw(Graphics g) {
        g.drawLine((int) x1.x, (int) x1.y, (int) x2.x, (int) x2.y);
    }
}
