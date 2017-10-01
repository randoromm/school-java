package praktikum15;

/**
 * fsaflsa
 * Created by rando on 25.11.16.
 */
public class Test {
    public static void main(String[] args) {
        Point p1 = new Point(5, 10);
        Point p2 = new Point(100, 150);
        Line line1 = new Line(p1, p2);
        Circle circle1 = new Circle(p2, 20);
        Cylinder cyl1 = new Cylinder(p2, 20, 10);

        System.out.println(p1);
        System.out.println(line1.getLength());
        System.out.println(circle1.getArea());
        System.out.println(circle1.getPerimetre());
        System.out.println(cyl1.getArea());
        System.out.println(cyl1.getVolume());
    }
}
