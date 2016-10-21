package praktikum10;

import java.util.ArrayList;

/**
 * sfjalfs
 * Created by rando on 10.10.16.
 */
public class MaxElement2Dvol2 {
    public static void main(String[] args) {
        int[][] neo = {
                {1, 3, 6, 7},
                {2, 3, 3, 1},
                {17, 4, 5, 0},
                {-20, 13, 16, 17}
        };
        System.out.println(maxElement2D(neo));
    }

    private static int maxElement1D(int[] elements) {
        int max = elements[0];
        for (int i : elements) {
            if(i > max) max = i;
        }
        return max;
    }
    private static int maxElement2D(int[][] elements) {
        int max = elements[0][0];
        for (int[] i : elements) {
            if(maxElement1D(i) > max) max = maxElement1D(i);
        }
        return max;
    }
}
