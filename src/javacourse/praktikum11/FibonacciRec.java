package javacourse.praktikum11;

/**
 * Fibonacci
 * 0, 1, 1, 2, 3, 5, 8, 13, 21...
 * Damn recursion...
 *
 * Created by rando on 3.11.16.
 */
public class FibonacciRec {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            System.out.println(count + ": " + getFibonacci(count));
            count++;
        }
    }

    private static int getFibonacci(int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;
        return getFibonacci(index - 2) + getFibonacci(index - 1);
    }
}
