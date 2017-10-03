package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;

/**
 * Drawing a spiral.
 * Created on 4.11.16.
 * @author Rando Rommot
 */
public class Spiral2 extends Applet{
    private Graphics gfx;
    public void paint(Graphics gfx) {
        this.gfx = gfx;
        drawBackground();
        drawSpiral(5, 10);
    }

    private void drawBackground() {
        gfx.setColor(Color.WHITE);
        gfx.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawSpiral(double radius, int circles) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        for (double alpha = 0; alpha <= 2 * Math.PI * circles; alpha += .0174533) {
            int x = (int) (radius * Math.cos(alpha));
            int y = (int) (radius * Math.sin(alpha));
            gfx.setColor(Color.BLACK);
            gfx.fillRect(x + centerX, y + centerY, 1, 1);
            radius += 0.03;
        }
    }
}
