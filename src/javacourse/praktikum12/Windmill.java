package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;

/**
 * Nonii
 * Created by rando on 10.11.16.
 */
public class Windmill extends Applet {
    private Graphics g;
    private boolean noLine = true;
    public void paint(Graphics g) {
        this.g = g;
        drawBackground();
        drawWindmill();
    }

    private void drawBackground() {
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);
    }

    private void drawWindmill() {
        double radius = 100;
        int x0 = getWidth() / 2;
        int y0 = getHeight() / 2;
        int x, y;
        int lastX = 0, lastY = 0;

        g.setColor(Color.RED);

        for (double a = 0; a <= 2 * Math.PI; a += 2 * Math.PI / 20) {
            x = (int) (radius * Math.cos(a));
            y = (int) (radius * Math.sin(a));
            if (noLine) noLine = false;
            else {
                g.drawLine(lastX, lastY, x + x0, y + y0);
                noLine = true;
            }

            g.fillRect(x + x0, y + y0, 1, 1);
            g.drawLine(x0, y0, x + x0, y + y0);
            lastX = x + x0;
            lastY = y + y0;
        }
    }
}
