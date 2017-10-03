package javacourse.praktikum12;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

/**
 * Recursive Tree
 * Created by rando on 10.11.16.
 */
public class RecursiveTree extends Applet {
    private Graphics2D g;
    public void paint(Graphics g) {
        this.g = (Graphics2D) g;

        int startX = getWidth() / 2;
        int startY = getHeight() - 10;
        int length = 50; // height of 1 branch in pixels
        int stroke = 10; // width of branch / stroke
        double alpha = -Math.PI / 2; // angle of one branch
        int green = 0;

        drawBackground();
        drawTree(startX, startY, length, stroke, alpha, green);
    }

    private void drawBackground() {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawTree(int startX, int startY, int length, int stroke, double alpha, int green) {
        if (stroke <= 0) return;
        if (length <= 0) return;
        if (green >= 255) green = 255;
        Random random = new Random();
        double r1 = random.nextInt(25 - 10 + 1) + 10;
        double r2 = random.nextInt(25 - 10 + 1) + 10;

        int endX = (int) (length * Math.cos(alpha)) + startX;
        int endY = (int) (length * Math.sin(alpha)) + startY;

        g.setColor(new Color(0, green, 0));
        g.setStroke(new BasicStroke(stroke));
        g.drawLine(startX, startY, endX, endY);

        drawTree(endX, endY, length - 5, stroke - 1, alpha + (2 * Math.PI / r1), green + 30);
        drawTree(endX, endY, length - 5, stroke - 1, alpha - (2 * Math.PI / r2), green + 30);
    }
}
