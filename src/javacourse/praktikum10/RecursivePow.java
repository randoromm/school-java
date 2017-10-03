package javacourse.praktikum10;

/**
 * ghdh
 * Created by rrommot on 21.10.16.
 */
public class RecursivePow {
    public static void main(String[] args) {
        System.out.println(astenda(2, 4));
    }

    private static int astenda(int arv, int aste) {
//        x^n -> if n is even = (x^(n/2))^2 , if odd = x * x^(n-1)
        int m;
        if (aste == 0) return 1;
        if (aste % 2 == 0) {
            m = astenda(arv, aste / 2);
            return m * m;
        } else return arv * astenda(arv, aste - 1);
    }
}
