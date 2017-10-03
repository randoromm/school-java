package javacourse.praktikum11;

/**
 * Fibonacci without recursion.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21...
 * Created by rando on 3.11.16.
 */
public class FibonacciEffective {
    public static void main(String[] args) {
        int count = 0;
        while (count < 50) {
            System.out.println(count + ": " + getFibonacci(count));
            count++;
        }
    }

    private static int getFibonacci(int index) {
        if (index == 0) return 0;
        if (index == 1) return 1;
        int[] fibona = new int[index + 1];
        fibona[0] = 0;
        fibona[1] = 1;
        for (int x = 2; x <= index; x++) {
            fibona[x] = fibona[x-2] + fibona[x-1];
        }
        return fibona[index];
    }
}
