package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;

public class PudeliHari extends Applet {
    /*
     * Ringjoone vo~rrand parameetrilisel kujul
     * x = r * cos(t) (nurga lähis kaatet)
     * y = r * sin(t) (nurga vastas kaatet)
     * t = -PI..PI
     */
    public void paint(Graphics g) {
        // Kysime kui suur aken on?
        int w = getWidth();
        int h = getHeight();

        int x0 = w / 2; // Keskpunkt
        int y0 = h / 2;

        int r = Math.min(y0, x0); // Raadius  (raadius vastavalt appleti suurusele)
        int x, y;
        double t;



        // Ta"idame tausta
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);

        // Joonistame
        g.setColor(Color.black);

        for (t = -Math.PI; t < Math.PI; t = t + Math.PI / 10) {
            x = (int) (r * Math.cos(t) + x0);
            y = (int) (r * Math.sin(t) + y0);
            g.drawLine(x0, y0, x, y);
        }
    }
}