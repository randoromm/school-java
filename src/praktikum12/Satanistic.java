package praktikum12;

import java.applet.Applet;
import java.awt.*;

public class Satanistic extends Applet {
    @Override
    public void paint(Graphics g) {
        int raadius = 100; // Raadius
        int sammudeArv = 5; // Nurkade arv
        int tiirudeArv = 2; // "Tiirude" arv
        double t0 = Math.PI / 2; // Faas ehk kust alustada
        int x, y, eelmineX = 0, eelmineY = 0;
        double t, i;
        boolean esimene = true;

        // Kysime laiuse / ko~rguse
        int w = getWidth();
        int h = getHeight();
        int x0 = w / 2; // Keskpunkt
        int y0 = h / 2;

        // Katame tausta
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, h);

        // Joonistame
        g.setColor(Color.RED);

        for (t = 0; t <= 2 * tiirudeArv * Math.PI; t = t + 2 * tiirudeArv * Math.PI / sammudeArv) {
            x = (int) (raadius * Math.cos(t + t0) + x0);
            y = (int) (raadius * Math.sin(t + t0) + y0);
            if (esimene) {
                esimene = false;
            }
            else {
                g.drawLine(x, y, eelmineX, eelmineY);
            }
            eelmineX = x;
            eelmineY = y;
        }

        for (i = 0; i <= 2 * Math.PI; i += .0174533) {
            x = (int) (raadius * Math.cos(i));
            y = (int) (raadius * Math.sin(i));
            g.fillRect(x + x0, y + y0, 1, 1);
        }
    }
}