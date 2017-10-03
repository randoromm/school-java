package javacourse.praktikum15;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

/**
 * Method to draw points, lines and circles.
 * Created by rando on 25.11.16.
 */
public class DrawShapes extends Applet{
    public void paint(Graphics g) {
        Point p1 = new Point(5, 10);
        Point p2 = new Point(100, 150);
        Point p3 = new Point(200, 50);
        Point p4 = new Point(300, 210);

        Line line1 = new Line(p1, p4);
        Circle circle1 = new Circle(p2, 20);

        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);

        drawBackground(g);
        drawPoint(p1, g);
        drawLine(line1, Color.BLUE, g);
        drawCircle(circle1, g);
        connectPoints(points, g);
    }

    private void connectPoints(ArrayList<Point> points, Graphics g) {
        for (int i = 0; i < points.size() - 1; i++) {
            Line l = new Line(points.get(i), points.get(i + 1));
            drawLine(l, Color.green, g);
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawCircle(Circle c, Graphics g) {
        int CentreX = c.center.getX();
        int CentreY = c.center.getY();
        double radius = c.radius;
        g.setColor(Color.ORANGE);

        for (double alpha = 0; alpha <= 2 * Math.PI; alpha += .0174533) {
            // Lähiskaatet = hypotenuus * cos alpha
            int x = (int) (radius * Math.cos(alpha));

            // Vastaskaatet = hypotenuud * sin alpha
            int y = (int) (radius * Math.sin(alpha));

            g.fillRect(CentreX + x, CentreY + y, 1, 1);
        }
    }

    private void drawLine(Line l, Color c, Graphics g) {
        g.setColor(c);
        g.drawLine(l.p1.getX(), l.p1.getY(), l.p2.getX(), l.p2.getY());
    }

    private void drawPoint(Point p, Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(p.getX(), p.getY(), 1, 1);
    }


}
