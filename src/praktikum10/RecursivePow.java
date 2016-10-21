package praktikum10;

/**
 * ghdh
 * Created by rrommot on 21.10.16.
 */
public class RecursivePow {
    public static void main(String[] args) {
        System.out.println(astenda(2, 6));
    }

    private static int astenda(int arv, int aste) {
        return (int) Math.pow(arv, aste);
    }
}
