package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;

/**
 * Some neat shit
 * Created by Rando on 16.11.2016.
 */
public class AppletTest extends Applet {
    @Override
    public void init() {
        // Init method is ran once when the program starts.
        setSize(500, 500);
    }

    @Override
    public void paint(Graphics g) {
        // Paint method is ran each time repainting is necessary. (ex. Resizing the applet viewer window)
        // Applet uses raster graphics (it's not dynamic by default), javaFX uses vector graphics.
        g.setColor(Color.RED);

        Polygon p = new Polygon();

        p.addPoint(0, 0);
        p.addPoint(0, 100);
        p. addPoint(200, 0);

        g.fillPolygon(p);
    }
}
