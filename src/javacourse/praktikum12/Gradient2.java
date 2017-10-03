package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;

/**
 * Improved version of gradient.
 * TODO Add support for two random color gradients! (rgb color to rgb color, play with concentrate)
 * Created by Rando on 16.11.2016.
 */
public class Gradient2 extends Applet {
    @Override
    public void init() {
        setSize(500, 500);
    }

    @Override
    public void paint(Graphics g) {
        int h = getHeight();

        for (int y = 0; y < h ; y++) {
            double concentrate = 1 - (double) y / h; // Arv ühest nullini.
            int rgb = (int) (concentrate * 255);
            g.setColor(new Color(255, rgb, 255));
            g.drawLine(0, y, getWidth(), y);
        }
    }
}
