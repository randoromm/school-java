package javacourse.praktikum5;

/**
 * Created by rando on 24.09.16.
 * A brick (cuboid) has dimensions a, b, c and a hole (rectangle) has dimensions x, y (all positive real numbers).
 * Write a Java method "mahub" to determine whether the brick passes the hole
 * (true - passes, false - does not pass in any direction, oblique positions are not allowed).
 */
public class cuboidBrick {
    public static void main(String[] args) {
        System.out.println(mahub(9, 6, 4, 3, 6));
    }
    private static boolean mahub (double a, double b, double c, double x, double y) {
        boolean fitThrough;
        double temp; // Temporary double, used to switch longer side of the hole to x variable.
        if (y > x) {
            temp = y;
            y = x;
            x = temp;
        }
        if (Math.max(a, b) <= x & Math.min(a, b) <= y) {
            fitThrough = true;
        }
        else if (Math.max(b, c) <= x & Math.min(b, c) <= y) {
            fitThrough = true;
        }
        else if (Math.max(a, c) <= x & Math.min(a, c) <= y) {
            fitThrough = true;
        } else {
            fitThrough = false;
        }
        return fitThrough;
    }
}
