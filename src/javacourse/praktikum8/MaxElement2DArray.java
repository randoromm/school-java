package javacourse.praktikum8;

/**
 * sfjalfs
 * Created by rando on 10.10.16.
 */
public class MaxElement2DArray {
    public static void main(String[] args) {
        System.out.println(maxElement1D(new int[] {1, -7, 12, 4, 5}));
        System.out.println(maxElement2D(new int[][] {{3, -7, 12, 4, 2}, {1, -5, 12, 9, 5}, {17, -7, 12, 99, 221}}));
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
