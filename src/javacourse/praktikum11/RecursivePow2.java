package javacourse.praktikum11;

/**
 * Getting harder :Z
 * Created by rando on 3.11.16.
 */
public class RecursivePow2 {
    public static void main(String[] args) {
        System.out.println(power(2, 40));
    }

    private static long power(long x, long n) {
        if (n == 0) return 1;
        long res;
        if (n % 2 == 0) {
            res = power(x, n / 2);
            return res * res;
        }
        return x * power(x, n - 1);
    }
}
