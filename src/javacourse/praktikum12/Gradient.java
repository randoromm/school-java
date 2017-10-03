package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;

/**
 * Damn, fix it. Make it able to draw chosen colors as gradient.
 * Created by Rando on 4.11.2016.
 */
public class Gradient extends Applet {
    Graphics gfx;
    public void paint(Graphics gfx) {
        this.gfx = gfx;
        drawGradient();
    }

    private void drawGradient() {
        int w = getWidth();
        int h = getHeight();
        int alpha = 0;
        Color myCol = new Color(0, 0, 0, alpha);
        gfx.setColor(Color.WHITE);
        gfx.fillRect(0, 0, w, h / 5);
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 4 * h / 5, w, h);

        for (int y = h / 5; y < h; y++) {
            for (int x = 0; x < w; x++) {
                gfx.setColor(myCol);
                gfx.fillRect(x, y, 1, 1);
            }
            if (alpha <= 253) alpha += 2;
            myCol = new Color(0, 0, 0, alpha);
        }
    }

}
