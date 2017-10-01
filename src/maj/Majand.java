package maj;

/**
 * Created by rando on 5/2/17.
 */
public class Majand {
    public static void main(String[] args) {
        System.out.println(calcMaj(205.75,37,48));
    }

    private static float calcMaj(double prof, int min, int max) {
        float result = 0;
        for (int i = min; i <= max; i++) {
            result += i * prof;
        }
        return result;
    }
}
