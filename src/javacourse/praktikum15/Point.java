package javacourse.praktikum15;

/**
 * Class for points, with x and y coordinate.
 * Created by rando on 25.11.16.
 */
public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X: " + x + "; Y: " + y + "\n";
    }
}
