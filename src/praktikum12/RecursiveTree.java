package praktikum12;

import java.applet.Applet;
import java.awt.*;

/**
 * Recursive Tree
 * Created by rando on 10.11.16.
 */
public class RecursiveTree extends Applet {
    Graphics g;
    public void paint(Graphics g) {
        this.g = g;
        drawBackground();
        drawTree();
    }

    private void drawBackground() {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawTree(int startX, int startY) {
        // TODO
    }
}
