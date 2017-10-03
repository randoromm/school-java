package javacourse.praktikum15;

/**
 * Circle with centre point and radius.
 * Created by rando on 25.11.16.
 */
public class Circle {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getPerimetre() {
        return 2 * Math.PI * radius;
    }
}
