package javacourse.praktikum15;

/**
 * Cylinder class.
 * Created by rando on 25.11.16.
 */
public class Cylinder extends Circle{
    private int height;

    public Cylinder(Point center, int radius, int height) {
        super(center, radius);
        this.height = height;
    }

    @Override
    double getArea() {
        return 2 * super.getArea() + height * super.getPerimetre();
    }

    double getVolume() {
        return super.getArea() * height;
    }
}
