package praktikum7;

/**
 * ahah
 * Created by rando on 5.10.16.
 */
public class Kontrolltoo {
    public static void main(String[] args) {
        System.out.println(summaAbsv(-2, -5));
        System.out.println(negPaaritu(-33));
        System.out.println(negElArv(new int[] {0, -1, 2, 3, -1, -2}));
        System.out.println(allaKeskmise(new double[] {0, -1, 2, 3, -1, -2}));
    }
    private static double summaAbsv (double a, double b) {
        return Math.abs(a + b);
    }
    private static boolean negPaaritu (int n) {
        return n % 2 != 0 && n < 0;
    }
    private static int negElArv (int[] m) {
        int count = 0;
        for(double x : m) {
            if (x < 0) count++;
        }
        return count;
    }
    private static int allaKeskmise (double[] d) {
        double sum = 0;
        double avg;
        int count = 0;
        for (double i : d) {
            sum += i;
        }
        avg = sum / d.length;
        for (double x : d) {
            if (x < avg) count++;
        }
        return count;
    }
}
