package praktikum10;

/**
 * gdgsdgsdg
 * Created by rrommot on 21.10.16.
 */
public class MaxElement {
    public static void main(String[] args) {
        int[] massiiv = {1, 3, 6, 7, 8, 3, 5, 7, 21, 3};
        System.out.println(maxElement(massiiv));
    }

    public static int maxElement(int[] list) {
        int max = list[0];
        for (int x : list) {
            if (x > max) max = x;
        }
        return max;
    }
}
