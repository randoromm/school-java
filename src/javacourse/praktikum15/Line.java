package javacourse.praktikum15;

/**
 * Line consists of two points.
 * Created by rando on 25.11.16.
 */
public class Line {
    Point p1;
    Point p2;
    private double length;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getLength() {
        double deltaX = Math.abs(p1.getX() - p2.getX());
        double deltaY = Math.abs(p1.getY() - p2.getY());
        double result = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return result;
    }

    public String toString() {
        return "POINT_1: " + p1 + " & POINT_2: " + p2 + "\n";
    }
}
